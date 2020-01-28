package com.utpl.plansvalidator.sql.indicador;

import com.utpl.plansvalidator.core.BaseEntity;
import com.utpl.plansvalidator.sql.rubrica.Rubrica;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Indicador extends BaseEntity {
    private String nombre;
    private String grupo;
    private Long rangoMinimo;
    private Long rangoMaximo;
    private String condicion;
    private String funcion;
    private String recomendaciones;
    @ManyToOne
    @JoinColumn(name = "rubrica_id")
    private Rubrica rubrica;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Long getRangoMinimo() {
        return rangoMinimo;
    }

    public void setRangoMinimo(Long rangoMinimo) {
        this.rangoMinimo = rangoMinimo;
    }

    public Long getRangoMaximo() {
        return rangoMaximo;
    }

    public void setRangoMaximo(Long rangoMaximo) {
        this.rangoMaximo = rangoMaximo;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public Rubrica getRubrica() {
        return rubrica;
    }

    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }
}
