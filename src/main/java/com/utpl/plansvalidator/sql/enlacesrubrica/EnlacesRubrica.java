package com.utpl.plansvalidator.sql.enlacesrubrica;

import com.utpl.plansvalidator.core.BaseEntity;
import com.utpl.plansvalidator.sql.plandocente.PlanDocente;
import com.utpl.plansvalidator.sql.rubrica.Rubrica;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EnlacesRubrica extends BaseEntity {
    @ManyToOne
    @JoinColumn(name="rubrica_id", nullable=false)
    private Rubrica rubrica;
    @ManyToOne
    @JoinColumn(name="planDocente_id", nullable=false)
    private PlanDocente planDocente;

    public Rubrica getRubrica() {
        return rubrica;
    }

    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }

    public PlanDocente getPlanDocente() {
        return planDocente;
    }

    public void setPlanDocente(PlanDocente planDocente) {
        this.planDocente = planDocente;
    }
}
