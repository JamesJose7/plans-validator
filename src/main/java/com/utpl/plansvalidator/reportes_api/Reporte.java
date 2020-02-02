package com.utpl.plansvalidator.reportes_api;

import java.util.ArrayList;
import java.util.List;

public class Reporte {
    private String name;
    private String description;
    private List<IndicadorReporte> indicadores;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<IndicadorReporte> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<IndicadorReporte> indicadores) {
        this.indicadores = indicadores;
    }

    public void addIndicador(IndicadorReporte indicador) {
        if (this.indicadores == null)
            this.indicadores = new ArrayList<>();
        this.indicadores.add(indicador);
    }

    public static class IndicadorReporte {
        private String groupName;
        private String name;
        private boolean successful;
        private String expected;
        private List<String> errors;

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSuccessful() {
            return successful;
        }

        public void setSuccessful(boolean successful) {
            this.successful = successful;
        }

        public String getExpected() {
            return expected;
        }

        public void setExpected(String expected) {
            this.expected = expected;
        }

        public List<String> getErrors() {
            return errors;
        }

        public void setErrors(List<String> errors) {
            this.errors = errors;
        }

        public void addError(String error) {
            if (this.errors == null)
                this.errors = new ArrayList<>();
            this.errors.add(error);
        }
    }
}
