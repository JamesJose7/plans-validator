package com.utpl.plansvalidator.sql.indicador;

public enum TipoIndicador {
    BINARY("Verdadero/Falso", 0),
    RANGE("Rango", 1);

    private String name;
    private int code;

    TipoIndicador(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

}
