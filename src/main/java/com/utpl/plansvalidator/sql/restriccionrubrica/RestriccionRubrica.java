package com.utpl.plansvalidator.sql.restriccionrubrica;

import com.utpl.plansvalidator.core.BaseEntity;
import com.utpl.plansvalidator.sql.plandocente.Plan;
import com.utpl.plansvalidator.sql.rubrica.Rubrica;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class RestriccionRubrica extends BaseEntity {
    @OneToOne
    private Rubrica rubrica;
    @OneToMany(mappedBy = "restriccionRubrica")
    private List<Plan> planesDocentesExcluidos;
    @OneToMany(mappedBy = "restriccionRubrica")
    private List<Plan> planesDocentesAdicionales;

    public Rubrica getRubrica() {
        return rubrica;
    }

    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }

    public List<Plan> getPlanesDocentesExcluidos() {
        return planesDocentesExcluidos;
    }

    public void setPlanesDocentesExcluidos(List<Plan> planesDocentesExcluidos) {
        this.planesDocentesExcluidos = planesDocentesExcluidos;
    }

    public List<Plan> getPlanesDocentesAdicionales() {
        return planesDocentesAdicionales;
    }

    public void setPlanesDocentesAdicionales(List<Plan> planesDocentesAdicionales) {
        this.planesDocentesAdicionales = planesDocentesAdicionales;
    }
}
