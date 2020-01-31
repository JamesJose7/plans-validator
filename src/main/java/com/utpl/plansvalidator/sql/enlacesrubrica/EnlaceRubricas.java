package com.utpl.plansvalidator.sql.enlacesrubrica;

import com.utpl.plansvalidator.core.BaseEntity;
import com.utpl.plansvalidator.sql.periodo.Periodo;
import com.utpl.plansvalidator.sql.rubrica.Rubrica;

import javax.persistence.*;
import java.util.List;

@Entity
public class EnlaceRubricas extends BaseEntity {
    @OneToOne
    @JoinColumn(unique = true)
    private Periodo periodo;
    @ManyToMany
    @JoinTable(
            name = "enlace_rubricas_mapper",
            joinColumns = @JoinColumn(name = "enlaceRubricas_id"),
            inverseJoinColumns = @JoinColumn(name = "rubrica_id"))
    private List<Rubrica> rubricas;

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public List<Rubrica> getRubricas() {
        return rubricas;
    }

    public void setRubricas(List<Rubrica> rubricas) {
        this.rubricas = rubricas;
    }
}
