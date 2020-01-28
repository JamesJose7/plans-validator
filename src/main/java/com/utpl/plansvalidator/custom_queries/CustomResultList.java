package com.utpl.plansvalidator.custom_queries;

import java.util.List;

public class CustomResultList {
    private List<String> columnNames;
    private List<Object[]> resultList;

    public CustomResultList(List<String> columnNames, List<Object[]> resultList) {
        this.columnNames = columnNames;
        this.resultList = resultList;
    }

    public CustomResultList() { }

    public List<String> getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(List<String> columnNames) {
        this.columnNames = columnNames;
    }

    public List<Object[]> getResultList() {
        return resultList;
    }

    public void setResultList(List<Object[]> resultList) {
        this.resultList = resultList;
    }
}
