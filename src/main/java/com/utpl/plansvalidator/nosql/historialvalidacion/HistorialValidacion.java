package com.utpl.plansvalidator.nosql.historialvalidacion;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
public class HistorialValidacion {
    @Id
    private Long id;
    private String fecha;
    private Long planDocenteId;
    private Long rubricaId;
    private Object resultado;

    public HistorialValidacion() { }

    public HistorialValidacion(Long id, String fecha, Long planDocenteId, Long rubricaId, Object resultado) {
        this.id = id;
        this.fecha = fecha;
        this.planDocenteId = planDocenteId;
        this.rubricaId = rubricaId;
        this.resultado = resultado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getPlanDocenteId() {
        return planDocenteId;
    }

    public void setPlanDocenteId(Long planDocenteId) {
        this.planDocenteId = planDocenteId;
    }

    public Long getRubricaId() {
        return rubricaId;
    }

    public void setRubricaId(Long rubricaId) {
        this.rubricaId = rubricaId;
    }

    public Object getResultado() {
        return resultado;
    }

    public void setResultado(Object resultado) {
        this.resultado = resultado;
    }
}
