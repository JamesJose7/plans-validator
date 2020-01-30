package com.utpl.plansvalidator.sql.periodo;

import com.utpl.plansvalidator.core.BaseEntity;
import com.utpl.plansvalidator.sql.enlacesrubrica.EnlaceRubricas;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Periodo extends BaseEntity {
    private String nombre;
    private String guid;
    private String codigo;
    private int id_canvas;

    @OneToOne
    private EnlaceRubricas enlaceRubricas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId_canvas() {
        return id_canvas;
    }

    public void setId_canvas(int id_canvas) {
        this.id_canvas = id_canvas;
    }

    public EnlaceRubricas getEnlaceRubricas() {
        return enlaceRubricas;
    }

    public void setEnlaceRubricas(EnlaceRubricas enlaceRubricas) {
        this.enlaceRubricas = enlaceRubricas;
    }
}
