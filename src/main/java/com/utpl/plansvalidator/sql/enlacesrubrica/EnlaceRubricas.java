package com.utpl.plansvalidator.sql.enlacesrubrica;

import com.utpl.plansvalidator.core.BaseEntity;
import com.utpl.plansvalidator.sql.periodo.Periodo;
import com.utpl.plansvalidator.sql.rubrica.Rubrica;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class EnlaceRubricas extends BaseEntity {
    @OneToOne
    private Periodo periodo;
    @OneToMany(mappedBy = "enlaceRubricas")
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
