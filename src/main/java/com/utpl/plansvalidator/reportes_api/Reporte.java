package com.utpl.plansvalidator.reportes_api;

import java.util.ArrayList;
import java.util.List;

public class Reporte {
    private String nombre;
    private String descripcion;
    private List<IndicadorReporte> indicadores;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        private String criterio;
        private String nombre;
        private boolean exitoso;
        private String condicion;
        private List<String> errores;

        public String getCriterio() {
            return criterio;
        }

        public void setCriterio(String criterio) {
            this.criterio = criterio;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public boolean isExitoso() {
            return exitoso;
        }

        public void setExitoso(boolean exitoso) {
            this.exitoso = exitoso;
        }

        public String getCondicion() {
            return condicion;
        }

        public void setCondicion(String condicion) {
            this.condicion = condicion;
        }

        public List<String> getErrores() {
            return errores;
        }

        public void setErrores(List<String> errores) {
            this.errores = errores;
        }

        public void addError(String error) {
            if (this.errores == null)
                this.errores = new ArrayList<>();
            this.errores.add(error);
        }
    }
}
