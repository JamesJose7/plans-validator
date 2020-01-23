package com.utpl.plansvalidator.sql.plandocente;

import com.utpl.plansvalidator.core.BaseEntity;
import com.utpl.plansvalidator.sql.enlacesrubrica.EnlacesRubrica;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class PlanDocente extends BaseEntity {
    private String prerequisitos;
    private String corequisitos;
    private String importancia;
    private String textoBaseEnBiblioteca;
    private String recursosComplementarios;
    private String oer;
    private String bibliografiaBasica;
    private String competenciaComponente;
    private String competenciaCarrera;

    @OneToMany(mappedBy = "planDocente")
    private List<EnlacesRubrica> enlacesRubricas;

    public String getPrerequisitos() {
        return prerequisitos;
    }

    public void setPrerequisitos(String prerequisitos) {
        this.prerequisitos = prerequisitos;
    }

    public String getCorequisitos() {
        return corequisitos;
    }

    public void setCorequisitos(String corequisitos) {
        this.corequisitos = corequisitos;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public String getTextoBaseEnBiblioteca() {
        return textoBaseEnBiblioteca;
    }

    public void setTextoBaseEnBiblioteca(String textoBaseEnBiblioteca) {
        this.textoBaseEnBiblioteca = textoBaseEnBiblioteca;
    }

    public String getRecursosComplementarios() {
        return recursosComplementarios;
    }

    public void setRecursosComplementarios(String recursosComplementarios) {
        this.recursosComplementarios = recursosComplementarios;
    }

    public String getOer() {
        return oer;
    }

    public void setOer(String oer) {
        this.oer = oer;
    }

    public String getBibliografiaBasica() {
        return bibliografiaBasica;
    }

    public void setBibliografiaBasica(String bibliografiaBasica) {
        this.bibliografiaBasica = bibliografiaBasica;
    }

    public String getCompetenciaComponente() {
        return competenciaComponente;
    }

    public void setCompetenciaComponente(String competenciaComponente) {
        this.competenciaComponente = competenciaComponente;
    }

    public String getCompetenciaCarrera() {
        return competenciaCarrera;
    }

    public void setCompetenciaCarrera(String competenciaCarrera) {
        this.competenciaCarrera = competenciaCarrera;
    }

    public List<EnlacesRubrica> getEnlacesRubricas() {
        return enlacesRubricas;
    }

    public void setEnlacesRubricas(List<EnlacesRubrica> enlacesRubricas) {
        this.enlacesRubricas = enlacesRubricas;
    }
}
