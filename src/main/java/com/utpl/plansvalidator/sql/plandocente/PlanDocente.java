package com.utpl.plansvalidator.sql.plandocente;

import com.utpl.plansvalidator.core.BaseEntity;
import com.utpl.plansvalidator.sql.enlacesrubrica.EnlacesRubrica;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class PlanDocente extends BaseEntity {
    private String nombre;
    @OneToMany(mappedBy = "planDocente")
    private List<EnlacesRubrica> enlacesRubricas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
