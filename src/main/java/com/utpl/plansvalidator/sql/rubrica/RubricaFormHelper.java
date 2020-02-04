package com.utpl.plansvalidator.sql.rubrica;

import com.utpl.plansvalidator.sql.indicador.Indicador;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RubricaFormHelper {
    private Long id;
    @NotNull
    @Size(min = 2, max = 100, message = "*Debe tener mínimo {min} caracteres y máximo {max}")
    private String nombre;
    private String descripcion;
    @Valid
    private List<Indicador> indicadores;
    private List<Indicador> existingIndicadores;

    public RubricaFormHelper() { }

    public RubricaFormHelper(String nombre, String descripcion, List<Indicador> indicadores) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.indicadores = indicadores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Indicador> getIndicadores() {
        if (indicadores == null) indicadores = new ArrayList<>();
        return indicadores;
    }

    public void setIndicadores(List<Indicador> indicadores) {
        this.indicadores = indicadores;
    }

    public List<Indicador> getExistingIndicadores() {
        if (existingIndicadores == null) existingIndicadores = new ArrayList<>();
        return existingIndicadores;
    }

    public void setExistingIndicadores(List<Indicador> existingIndicadores) {
        this.existingIndicadores = existingIndicadores;
    }

    public Rubrica getRubrica() {
        return new Rubrica(nombre, descripcion,
                Stream.concat(getIndicadores().stream(), getExistingIndicadores().stream()).collect(Collectors.toList()));
    }

    public static RubricaFormHelper wrapRubrica(Rubrica rubrica) {
        return new RubricaFormHelper(rubrica.getNombre(), rubrica.getDescripcion(), rubrica.getIndicadores());
    }
}
