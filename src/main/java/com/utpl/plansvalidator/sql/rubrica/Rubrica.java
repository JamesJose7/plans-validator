package com.utpl.plansvalidator.sql.rubrica;

import com.utpl.plansvalidator.core.BaseEntity;
import com.utpl.plansvalidator.sql.enlacesrubrica.EnlacesRubrica;
import com.utpl.plansvalidator.sql.indicador.Indicador;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Rubrica extends BaseEntity {
    private String nombre;
    private String descripcion;
    @OneToMany(mappedBy = "rubrica", cascade = CascadeType.ALL)
    private List<Indicador> indicadores;
    @OneToMany(mappedBy = "rubrica")
    private List<EnlacesRubrica> enlacesRubricas;

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

    public List<EnlacesRubrica> getEnlacesRubricas() {
        return enlacesRubricas;
    }

    public void setEnlacesRubricas(List<EnlacesRubrica> enlacesRubricas) {
        this.enlacesRubricas = enlacesRubricas;
    }
}
