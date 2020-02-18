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
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlanDocenteQueryResolver {
    public static final String QUERY_WRAPPER = "SELECT * FROM (%s) t WHERE %s";

    @PersistenceContext
    private EntityManager entityManager;

    public CustomResultList binaryResult(String query, String condition, int planId) throws JSQLParserException, SQLSyntaxErrorException {
//        String[] splitQuery = query.toLowerCase().split("from");
//        query = String.format(QUERY_WRAPPER, splitQuery[0], splitQuery[1], condition, planId);
        query = String.format(QUERY_WRAPPER, query, condition);
        if (query.contains("@{idPlan}"))
            query = query.replaceAll("@\\{idPlan}", planId + "");
        return executeQuery(query);
    }

    public CustomResultList rangeResult(String query, String condition, int planId) throws JSQLParserException, SQLSyntaxErrorException {
        if (query.contains("@{idPlan}"))
            query = query.replaceAll("@\\{idPlan}", planId + "");
        // Get single result from query
        Optional<Double> resultOptional = executeQuery(query).getResultList().stream()
                .map(o -> {
                    if (o.length > 0)
                        if (o[0] instanceof Number)
                            return Double.parseDouble(o[0].toString());
                    return 0.0;
                })
                .findFirst();
        Double result = resultOptional.orElse(0.0);
        String[] ranges = condition.split("<");
        Double min = Double.parseDouble(ranges[0].trim());
        Double max = Double.parseDouble(ranges[1].trim());

        Object[] integers = {result, min, max};
        return new CustomResultList(
                Arrays.asList("result", "min", "max"),
                Collections.singletonList(integers));
    }

    private CustomResultList executeQuery(String query) throws JSQLParserException, SQLSyntaxErrorException {
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
