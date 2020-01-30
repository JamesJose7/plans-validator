package com.utpl.plansvalidator.sql.plandocente;

import com.utpl.plansvalidator.core.BaseEntity;
import com.utpl.plansvalidator.sql.periodo.Periodo;
import com.utpl.plansvalidator.sql.restriccionrubrica.RestriccionRubrica;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Plan extends BaseEntity {

    private String ciclo;
    private int campo_formacion;
    private int organizacion_curricular;

    @ManyToOne
    @JoinColumn(name="periodo")
    private Periodo periodo;

    @Column(columnDefinition="TEXT")
    private String prerequisitos;
    @Column(columnDefinition="TEXT")
    private String corequisitos;
    @Column(columnDefinition="TEXT")
    private String importancia;
    private String texto_base_en_biblioteca;
    @Column(columnDefinition="TEXT")
    private String recursos_complementarios;
    @Column(columnDefinition="TEXT")
    private String oer;
    private String paralelo;
    private String guid;
    @Column(columnDefinition="TEXT")
    private String bibliografia_basica;
    private int componente;
    private Timestamp register;
    @Column(columnDefinition="TEXT")
    private String competencia_componente;
    private double puntaje_docencia_b1;
    private double puntaje_docencia_b2;
    private double puntaje_practica_b1;
    private double puntaje_practica_b2;
    private double puntaje_autonomo_b1;
    private double puntaje_autonomo_b2;
    @Column(columnDefinition="TEXT")
    private String competencia_carrera;
    private int modalidad;
    @Column(columnDefinition="TEXT")
    private String presentacion;
    @Column(columnDefinition="TEXT")
    private String contextualizacion;
    @Column(columnDefinition="TEXT")
    private String adaptacion_curricular;
    private int tipo_asignatura;
    @Column(columnDefinition="TEXT")
    private String presentacion_html;
    @Column(columnDefinition="TEXT")
    private String contextualizacion_html;
    @Column(columnDefinition="TEXT")
    private String importancia_html;
    @Column(columnDefinition="TEXT")
    private String prerequisitos_html;
    @Column(columnDefinition="TEXT")
    private String adaptacion_curricular_html;

    @ManyToOne
    @JoinColumn(name="restriccionRubrica_id")
    private RestriccionRubrica restriccionRubrica;

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public int getCampo_formacion() {
        return campo_formacion;
    }

    public void setCampo_formacion(int campo_formacion) {
        this.campo_formacion = campo_formacion;
    }

    public int getOrganizacion_curricular() {
        return organizacion_curricular;
    }

    public void setOrganizacion_curricular(int organizacion_curricular) {
        this.organizacion_curricular = organizacion_curricular;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
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

    public String getTexto_base_en_biblioteca() {
        return texto_base_en_biblioteca;
    }

    public void setTexto_base_en_biblioteca(String texto_base_en_biblioteca) {
        this.texto_base_en_biblioteca = texto_base_en_biblioteca;
    }

    public String getRecursos_complementarios() {
        return recursos_complementarios;
    }

    public void setRecursos_complementarios(String recursos_complementarios) {
        this.recursos_complementarios = recursos_complementarios;
    }

    public String getOer() {
        return oer;
    }

    public void setOer(String oer) {
        this.oer = oer;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getBibliografia_basica() {
        return bibliografia_basica;
    }

    public void setBibliografia_basica(String bibliografia_basica) {
        this.bibliografia_basica = bibliografia_basica;
    }

    public int getComponente() {
        return componente;
    }

    public void setComponente(int componente) {
        this.componente = componente;
    }

    public Timestamp getRegister() {
        return register;
    }

    public void setRegister(Timestamp register) {
        this.register = register;
    }

    public String getCompetencia_componente() {
        return competencia_componente;
    }

    public void setCompetencia_componente(String competencia_componente) {
        this.competencia_componente = competencia_componente;
    }

    public double getPuntaje_docencia_b1() {
        return puntaje_docencia_b1;
    }

    public void setPuntaje_docencia_b1(double puntaje_docencia_b1) {
        this.puntaje_docencia_b1 = puntaje_docencia_b1;
    }

    public double getPuntaje_docencia_b2() {
        return puntaje_docencia_b2;
    }

    public void setPuntaje_docencia_b2(double puntaje_docencia_b2) {
        this.puntaje_docencia_b2 = puntaje_docencia_b2;
    }

    public double getPuntaje_practica_b1() {
        return puntaje_practica_b1;
    }

    public void setPuntaje_practica_b1(double puntaje_practica_b1) {
        this.puntaje_practica_b1 = puntaje_practica_b1;
    }

    public double getPuntaje_practica_b2() {
        return puntaje_practica_b2;
    }

    public void setPuntaje_practica_b2(double puntaje_practica_b2) {
        this.puntaje_practica_b2 = puntaje_practica_b2;
    }

    public double getPuntaje_autonomo_b1() {
        return puntaje_autonomo_b1;
    }

    public void setPuntaje_autonomo_b1(double puntaje_autonomo_b1) {
        this.puntaje_autonomo_b1 = puntaje_autonomo_b1;
    }

    public double getPuntaje_autonomo_b2() {
        return puntaje_autonomo_b2;
    }

    public void setPuntaje_autonomo_b2(double puntaje_autonomo_b2) {
        this.puntaje_autonomo_b2 = puntaje_autonomo_b2;
    }

    public String getCompetencia_carrera() {
        return competencia_carrera;
    }

    public void setCompetencia_carrera(String competencia_carrera) {
        this.competencia_carrera = competencia_carrera;
    }

    public int getModalidad() {
        return modalidad;
    }

    public void setModalidad(int modalidad) {
        this.modalidad = modalidad;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getContextualizacion() {
        return contextualizacion;
    }

    public void setContextualizacion(String contextualizacion) {
        this.contextualizacion = contextualizacion;
    }

    public String getAdaptacion_curricular() {
        return adaptacion_curricular;
    }

    public void setAdaptacion_curricular(String adaptacion_curricular) {
        this.adaptacion_curricular = adaptacion_curricular;
    }

    public int getTipo_asignatura() {
        return tipo_asignatura;
    }

    public void setTipo_asignatura(int tipo_asignatura) {
        this.tipo_asignatura = tipo_asignatura;
    }

    public String getPresentacion_html() {
        return presentacion_html;
    }

    public void setPresentacion_html(String presentacion_html) {
        this.presentacion_html = presentacion_html;
    }

    public String getContextualizacion_html() {
        return contextualizacion_html;
    }

    public void setContextualizacion_html(String contextualizacion_html) {
        this.contextualizacion_html = contextualizacion_html;
    }

    public String getImportancia_html() {
        return importancia_html;
    }

    public void setImportancia_html(String importancia_html) {
        this.importancia_html = importancia_html;
    }

    public String getPrerequisitos_html() {
        return prerequisitos_html;
    }

    public void setPrerequisitos_html(String prerequisitos_html) {
        this.prerequisitos_html = prerequisitos_html;
    }

    public String getAdaptacion_curricular_html() {
        return adaptacion_curricular_html;
    }

    public void setAdaptacion_curricular_html(String adaptacion_curricular_html) {
        this.adaptacion_curricular_html = adaptacion_curricular_html;
    }

    public RestriccionRubrica getRestriccionRubrica() {
        return restriccionRubrica;
    }

    public void setRestriccionRubrica(RestriccionRubrica restriccionRubrica) {
        this.restriccionRubrica = restriccionRubrica;
    }
}
