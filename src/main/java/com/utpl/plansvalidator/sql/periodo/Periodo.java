package com.utpl.plansvalidator.sql.periodo;

import com.utpl.plansvalidator.sql.enlacesrubrica.EnlaceRubricas;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "periodo")
public class Periodo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "guid")
    private String guid;
    @Size(max = 45)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_canvas")
    private int idCanvas;

    @OneToOne
    private EnlaceRubricas enlaceRubricas;

    public Periodo() {}

    public Periodo(Integer id) {
        this.id = id;
    }

    public Periodo(Integer id, int idCanvas) {
        this.id = id;
        this.idCanvas = idCanvas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public int getIdCanvas() {
        return idCanvas;
    }

    public void setIdCanvas(int idCanvas) {
        this.idCanvas = idCanvas;
    }

    public EnlaceRubricas getEnlaceRubricas() {
        return enlaceRubricas;
    }

    public void setEnlaceRubricas(EnlaceRubricas enlaceRubricas) {
        this.enlaceRubricas = enlaceRubricas;
    }
}
