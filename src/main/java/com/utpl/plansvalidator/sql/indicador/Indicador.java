package com.utpl.plansvalidator.sql.indicador;

import com.utpl.plansvalidator.core.BaseEntity;
import com.utpl.plansvalidator.sql.rubrica.Rubrica;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Indicador extends BaseEntity {
    // TODO: ADD TIPO

    @NotNull
    @Size(min = 2, max = 50, message = "*Debe tener mínimo {min} caracteres y máximo {max}")
    private String nombre;
    @NotNull
    @Size(min = 1, message = "*No puede estar vacía")
    private String descripcion;
    @NotNull
    @Size(min = 2, max = 50, message = "*Debe tener mínimo {min} caracteres y máximo {max}")
    private String criterio;
    private Long rangoMinimo;
    private Long rangoMaximo;
    @NotNull
    @Size(min = 1, message = "*No puede estar vacía")
    private String condicion;
    @NotNull
    @Size(min = 1, message = "*No puede estar vacía")
    private String funcion;
    private String recomendaciones;

    @ManyToMany
    @JoinTable(
            name = "indicadores_rubrica",
            joinColumns = @JoinColumn(name = "indicador_id"),
            inverseJoinColumns = @JoinColumn(name = "rubrica_id"))
    private List<Rubrica> rubricas;

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

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
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

    public List<Rubrica> getRubricas() {
        return rubricas;
    }

    public void setRubricas(List<Rubrica> rubricas) {
        this.rubricas = rubricas;
    }

    public void addRubrica(Rubrica rubrica) {
        if (this.rubricas == null)
            this.rubricas = new ArrayList<>();
        this.rubricas.add(rubrica);
    }
}
