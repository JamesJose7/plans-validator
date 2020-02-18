package com.utpl.plansvalidator.reportes_api;

import java.util.ArrayList;
import java.util.List;

public class Reporte {
    private String nombre;
    private String descripcion;
    private List<IndicadorReporteGroup> grupos;

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

    public List<IndicadorReporteGroup> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<IndicadorReporteGroup> grupos) {
        this.grupos = grupos;
    }

    public void addIndicador(IndicadorReporteGroup indicadorReporteGroup) {
        if (this.grupos == null)
            this.grupos = new ArrayList<>();
        this.grupos.add(indicadorReporteGroup);
    }

    public static class IndicadorReporteGroup {
        private String nombre;
        private List<IndicadorReporte> indicadores;

        public IndicadorReporteGroup() {}

        public IndicadorReporteGroup(String nombre, List<IndicadorReporte> indicadores) {
            this.nombre = nombre;
            this.indicadores = indicadores;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public List<IndicadorReporte> getIndicadores() {
            return indicadores;
        }

        public void setIndicadores(List<IndicadorReporte> indicadores) {
            this.indicadores = indicadores;
        }
    }

    public static class IndicadorReporte {
        private Long id;
        private int tipo;
        private String criterio;
        private String nombre;
        private String descripcion;
        private Object resultado;
        private String condicion;
        private List<String> errores;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public int getTipo() {
            return tipo;
        }

        public void setTipo(int tipo) {
            this.tipo = tipo;
        }

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

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public Object getResultado() {
            return resultado;
        }

        public void setResultado(Object resultado) {
            this.resultado = resultado;
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

    public static class ResultadoRango {
        private double resultado;
        private double min;
        private double max;

        public ResultadoRango() { }

        public ResultadoRango(double resultado, double min, double max) {
            this.resultado = resultado;
            this.min = min;
            this.max = max;
        }

        public double getResultado() {
            return resultado;
        }

        public void setResultado(double resultado) {
            this.resultado = resultado;
        }

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }
    }
}
