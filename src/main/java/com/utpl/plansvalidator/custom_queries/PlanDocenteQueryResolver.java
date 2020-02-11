package com.utpl.plansvalidator.custom_queries;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.util.TablesNamesFinder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanDocenteQueryResolver {
    public static final String QUERY_WRAPPER = "SELECT * FROM (%s, id as id from %s) t WHERE %s AND id=%d";

    @PersistenceContext
    private EntityManager entityManager;

    public CustomResultList executeQuery(String query, String condition, int planId) throws JSQLParserException, SQLSyntaxErrorException {
        String[] splitQuery = query.toLowerCase().split("from");
        query = String.format(QUERY_WRAPPER, splitQuery[0], splitQuery[1], condition, planId);
        List<String> columnNames = new ArrayList<>();

        // Parse query to get aliases while also checking it's a valid select statement and no other query
        Select selectQuery = (Select) CCJSqlParserUtil.parse(query);
        TablesNamesFinder tablesNamesFinder = new TablesNamesFinder() {
            @Override
            public void visit(Column tableColumn) {
                // Gets the column names but should only use aliases
//                columnNames.add(tableColumn.getColumnName());
            }

            @Override
            public void visit(SelectExpressionItem item) {
                // To get aliases
                super.visit(item);
                columnNames.add(item.getAlias().getName());
            }
        };
        tablesNamesFinder.getTableList(selectQuery);
        // Execute the query on the DB model and retrieve a custom result object with aliases and rows
        try {
            List<Object> resultList = entityManager.createNativeQuery(query).getResultList();
            List<Object[]> transformedResult = resultList.stream()
                    .map(obj -> {
                        if (obj instanceof Object[])
                            return (Object[]) obj;
                        return new Object[]{obj};
                    })
                    .collect(Collectors.toList());
            return new CustomResultList(columnNames, transformedResult);
        } catch (Exception e) {
            throw new SQLSyntaxErrorException();
        }
    }
}
