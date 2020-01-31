package com.utpl.plansvalidator.sql.rubrica;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubricaRepository extends CrudRepository<Rubrica, Long> {
    @NotNull
    @Override
    List<Rubrica> findAll();
}
