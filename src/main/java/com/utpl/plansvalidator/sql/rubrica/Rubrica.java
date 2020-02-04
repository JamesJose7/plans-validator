package com.utpl.plansvalidator.sql.rubrica;

import com.utpl.plansvalidator.core.BaseEntity;
import com.utpl.plansvalidator.sql.enlacesrubrica.EnlaceRubricas;
import com.utpl.plansvalidator.sql.indicador.Indicador;
import com.utpl.plansvalidator.sql.restriccionrubrica.RestriccionRubrica;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
public class Rubrica extends BaseEntity {
    @NotNull
    @Size(min = 2, max = 100, message = "*Debe tener mínimo {min} caracteres y máximo {max}")
    private String nombre;
    private String descripcion;
    @Valid
    @ManyToMany(mappedBy = "rubricas")
    private List<Indicador> indicadores;

    @ManyToMany(mappedBy = "rubricas")
    private Set<EnlaceRubricas> enlaceRubricas;
    @OneToOne
    private RestriccionRubrica restriccion;

    public Rubrica() { }

    public Rubrica(String nombre, String descripcion, List<Indicador> indicadores) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.indicadores = indicadores;
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

    public List<Indicador> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<Indicador> indicadores) {
        this.indicadores = indicadores;
    }

    public Set<EnlaceRubricas> getEnlaceRubricas() {
        return enlaceRubricas;
    }

    public void setEnlaceRubricas(Set<EnlaceRubricas> enlaceRubricas) {
        this.enlaceRubricas = enlaceRubricas;
    }

    public void addEnlaceRubricas(EnlaceRubricas enlaceRubricas) {
        this.enlaceRubricas.add(enlaceRubricas);
    }

    public RestriccionRubrica getRestriccion() {
        return restriccion;
    }

    public void setRestriccion(RestriccionRubrica restriccion) {
        this.restriccion = restriccion;
    }
}
