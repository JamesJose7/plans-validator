package com.utpl.plansvalidator.sql.periodo;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodoRepository extends CrudRepository<Periodo, Long> {
    @NotNull
    @Override
    List<Periodo> findAll();
    List<Periodo> findAllByEnlaceRubricasIsNull();
}
