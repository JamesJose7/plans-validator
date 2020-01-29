package com.utpl.plansvalidator.sql.indicador;

import com.utpl.plansvalidator.core.BaseEntity;
import com.utpl.plansvalidator.sql.rubrica.Rubrica;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Indicador extends BaseEntity {
    @NotNull
    @Size(min = 2, max = 50, message = "*Debe tener mínimo {min} caracteres y máximo {max}")
    private String nombre;
    @NotNull
    @Size(min = 2, max = 50, message = "*Debe tener mínimo {min} caracteres y máximo {max}")
    private String grupo;
    private Long rangoMinimo;
    private Long rangoMaximo;
    @NotNull
    @Size(min = 2, message = "*No puede estar vacía")
    private String condicion;
    @NotNull
    @Size(min = 2, message = "*No puede estar vacía")
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
