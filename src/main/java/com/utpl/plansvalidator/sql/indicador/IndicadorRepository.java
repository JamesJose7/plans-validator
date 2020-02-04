package com.utpl.plansvalidator.sql.indicador;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndicadorRepository extends CrudRepository<Indicador, Long> {
    @NotNull
    @Override
    List<Indicador> findAll();
}
