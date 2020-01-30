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

@Entity
public class Rubrica extends BaseEntity {
    @NotNull
    @Size(min = 2, max = 100, message = "*Debe tener mínimo {min} caracteres y máximo {max}")
    private String nombre;
    private String descripcion;
    @Valid
    @OneToMany(mappedBy = "rubrica", cascade = CascadeType.ALL)
    private List<Indicador> indicadores;

    @ManyToOne
    @JoinColumn(name="enlaceRubricas_id", nullable=false)
    private EnlaceRubricas enlaceRubricas;
    @OneToOne
    private RestriccionRubrica restriccion;

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

    public EnlaceRubricas getEnlaceRubricas() {
        return enlaceRubricas;
    }

    public void setEnlaceRubricas(EnlaceRubricas enlaceRubricas) {
        this.enlaceRubricas = enlaceRubricas;
    }

    public RestriccionRubrica getRestriccion() {
        return restriccion;
    }

    public void setRestriccion(RestriccionRubrica restriccion) {
        this.restriccion = restriccion;
    }
}
