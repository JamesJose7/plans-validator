package com.utpl.plansvalidator.sql.plandocente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utpl.plansvalidator.sql.componente.Componente;
import com.utpl.plansvalidator.sql.periodo.Periodo;
import com.utpl.plansvalidator.sql.restriccionrubrica.RestriccionRubrica;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "plan")
public class Plan implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @Size(max = 45)
    @Column(name = "ciclo")
    private String ciclo;
    @Lob
    @Size(max = 65535)
    @Column(name = "prerequisitos")
    private String prerequisitos;
    @Lob
    @Size(max = 65535)
    @Column(name = "corequisitos")
    private String corequisitos;
    @Lob
    @Size(max = 65535)
    @Column(name = "importancia")
    private String importancia;
    @Size(max = 2)
    @Column(name = "texto_base_en_biblioteca")
    private String textoBaseEnBiblioteca;
    @Lob
    @Size(max = 65535)
    @Column(name = "recursos_complementarios")
    private String recursosComplementarios;
    @Lob
    @Size(max = 65535)
    @Column(name = "oer")
    private String oer;

    @JsonIgnore
    @Size(max = 45)
    @Column(name = "paralelo")
    private String paralelo;

    @JsonIgnore
    @Size(max = 45)
    @Column(name = "guid")
    private String guid;
    @Lob
    @Size(max = 65535)
    @Column(name = "bibliografia_basica")
    private String bibliografiaBasica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "register")
    @Temporal(TemporalType.TIMESTAMP)
    private Date register;
    @Lob
    @Size(max = 65535)
    @Column(name = "competencia_componente")
    private String competenciaComponente;

    @Lob
    @Size(max = 65535)
    @Column(name = "competencia_carrera")
    private String competenciaCarrera;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "puntaje_docencia_b1")
    private BigDecimal puntajeDocenciaB1;
    @Column(name = "puntaje_docencia_b2")
    private BigDecimal puntajeDocenciaB2;
    @Column(name = "puntaje_practica_b1")
    private BigDecimal puntajePracticaB1;
    @Column(name = "puntaje_practica_b2")
    private BigDecimal puntajePracticaB2;
    @Column(name = "puntaje_autonomo_b1")
    private BigDecimal puntajeAutonomoB1;
    @Column(name = "puntaje_autonomo_b2")
    private BigDecimal puntajeAutonomoB2;

    @Lob
    @Size(max = 65535)
    @Column(name = "presentacion")
    private String presentacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "contextualizacion")
    private String contextualizacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "adaptacion_curricular")
    private String adaptacionCurricular;

    @Lob
    @Size(max = 65535)
    @Column(name = "presentacion_html")
    private String presentacionHtml;
    @Lob
    @Size(max = 65535)
    @Column(name = "contextualizacion_html")
    private String contextualizacionHtml;
    @Lob
    @Size(max = 65535)
    @Column(name = "importancia_html")
    private String importanciaHtml;
    @Lob
    @Size(max = 65535)
    @Column(name = "prerequisitos_html")
    private String prerequisitosHtml;
    @Lob
    @Size(max = 65535)
    @Column(name = "adaptacion_curricular_html")
    private String adaptacionCurricularHtml;

    @JoinColumn(name = "periodo", referencedColumnName = "id")
    @ManyToOne
    private Periodo periodo;

    @JoinColumn(name = "componente", referencedColumnName = "id")
    @ManyToOne
    private Componente componente;

    @ManyToOne
    @JoinColumn(name="restriccionRubrica_id")
    private RestriccionRubrica restriccionRubrica;


    public Plan() {
    }

    public Plan(Integer id) {
        this.id = id;
    }

    public Plan(Integer id, Date register) {
        this.id = id;
        this.register = register;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
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

    public String getBibliografiaBasica() {
        return bibliografiaBasica;
    }

    public void setBibliografiaBasica(String bibliografiaBasica) {
        this.bibliografiaBasica = bibliografiaBasica;
    }

    public Date getRegister() {
        return register;
    }

    public void setRegister(Date register) {
        this.register = register;
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

    public BigDecimal getPuntajeDocenciaB1() {
        return puntajeDocenciaB1;
    }

    public void setPuntajeDocenciaB1(BigDecimal puntajeDocenciaB1) {
        this.puntajeDocenciaB1 = puntajeDocenciaB1;
    }

    public BigDecimal getPuntajeDocenciaB2() {
        return puntajeDocenciaB2;
    }

    public void setPuntajeDocenciaB2(BigDecimal puntajeDocenciaB2) {
        this.puntajeDocenciaB2 = puntajeDocenciaB2;
    }

    public BigDecimal getPuntajePracticaB1() {
        return puntajePracticaB1;
    }

    public void setPuntajePracticaB1(BigDecimal puntajePracticaB1) {
        this.puntajePracticaB1 = puntajePracticaB1;
    }

    public BigDecimal getPuntajePracticaB2() {
        return puntajePracticaB2;
    }

    public void setPuntajePracticaB2(BigDecimal puntajePracticaB2) {
        this.puntajePracticaB2 = puntajePracticaB2;
    }

    public BigDecimal getPuntajeAutonomoB1() {
        return puntajeAutonomoB1;
    }

    public void setPuntajeAutonomoB1(BigDecimal puntajeAutonomoB1) {
        this.puntajeAutonomoB1 = puntajeAutonomoB1;
    }

    public BigDecimal getPuntajeAutonomoB2() {
        return puntajeAutonomoB2;
    }

    public void setPuntajeAutonomoB2(BigDecimal puntajeAutonomoB2) {
        this.puntajeAutonomoB2 = puntajeAutonomoB2;
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

    public String getAdaptacionCurricular() {
        return adaptacionCurricular;
    }

    public void setAdaptacionCurricular(String adaptacionCurricular) {
        this.adaptacionCurricular = adaptacionCurricular;
    }

    public String getPresentacionHtml() {
        return presentacionHtml;
    }

    public void setPresentacionHtml(String presentacionHtml) {
        this.presentacionHtml = presentacionHtml;
    }

    public String getContextualizacionHtml() {
        return contextualizacionHtml;
    }

    public void setContextualizacionHtml(String contextualizacionHtml) {
        this.contextualizacionHtml = contextualizacionHtml;
    }

    public String getImportanciaHtml() {
        return importanciaHtml;
    }

    public void setImportanciaHtml(String importanciaHtml) {
        this.importanciaHtml = importanciaHtml;
    }

    public String getPrerequisitosHtml() {
        return prerequisitosHtml;
    }

    public void setPrerequisitosHtml(String prerequisitosHtml) {
        this.prerequisitosHtml = prerequisitosHtml;
    }

    public String getAdaptacionCurricularHtml() {
        return adaptacionCurricularHtml;
    }

    public void setAdaptacionCurricularHtml(String adaptacionCurricularHtml) {
        this.adaptacionCurricularHtml = adaptacionCurricularHtml;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public RestriccionRubrica getRestriccionRubrica() {
        return restriccionRubrica;
    }

    public void setRestriccionRubrica(RestriccionRubrica restriccionRubrica) {
        this.restriccionRubrica = restriccionRubrica;
    }
}
