package com.utpl.plansvalidator.sql.plandocente;

import com.google.gson.annotations.Expose;
import com.utpl.plansvalidator.core.BaseEntity;
import com.utpl.plansvalidator.sql.enlacesrubrica.EnlacesRubrica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class PlanDocente extends BaseEntity {
    private String componente;
    private String periodo;

    @Expose
    private String prerequisitos;
    @Expose
    private String corequisitos;
    @Expose
    @Column(columnDefinition = "LONGTEXT")
    private String importancia;
    @Expose
    @Column(columnDefinition = "LONGTEXT")
    private String textoBaseEnBiblioteca;
    @Expose
    @Column(columnDefinition = "LONGTEXT")
    private String recursosComplementarios;
    @Expose
    private String oer;
    @Expose
    private String bibliografiaBasica;
    @Expose
    @Column(columnDefinition = "LONGTEXT")
    private String competenciaComponente;
    @Expose
    @Column(columnDefinition = "LONGTEXT")
    private String competenciaCarrera;

    @Expose
    private int puntajeDocenciaB1;
    @Expose
    private int puntajeDocenciaB2;
    @Expose
    private int puntajePracticaB1;
    @Expose
    private int puntajePracticaB2;
    @Expose
    private int puntajeAutonomoB1;
    @Expose
    private int puntajeAutonomoB2;

    @OneToMany(mappedBy = "planDocente")
    private List<EnlacesRubrica> enlacesRubricas;

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

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

    public int getPuntajeDocenciaB1() {
        return puntajeDocenciaB1;
    }

    public void setPuntajeDocenciaB1(int puntajeDocenciaB1) {
        this.puntajeDocenciaB1 = puntajeDocenciaB1;
    }

    public int getPuntajeDocenciaB2() {
        return puntajeDocenciaB2;
    }

    public void setPuntajeDocenciaB2(int puntajeDocenciaB2) {
        this.puntajeDocenciaB2 = puntajeDocenciaB2;
    }

    public int getPuntajePracticaB1() {
        return puntajePracticaB1;
    }

    public void setPuntajePracticaB1(int puntajePracticaB1) {
        this.puntajePracticaB1 = puntajePracticaB1;
    }

    public int getPuntajePracticaB2() {
        return puntajePracticaB2;
    }

    public void setPuntajePracticaB2(int puntajePracticaB2) {
        this.puntajePracticaB2 = puntajePracticaB2;
    }

    public int getPuntajeAutonomoB1() {
        return puntajeAutonomoB1;
    }

    public void setPuntajeAutonomoB1(int puntajeAutonomoB1) {
        this.puntajeAutonomoB1 = puntajeAutonomoB1;
    }

    public int getPuntajeAutonomoB2() {
        return puntajeAutonomoB2;
    }

    public void setPuntajeAutonomoB2(int puntajeAutonomoB2) {
        this.puntajeAutonomoB2 = puntajeAutonomoB2;
    }
}
