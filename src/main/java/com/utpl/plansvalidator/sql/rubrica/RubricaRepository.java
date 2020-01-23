package com.utpl.plansvalidator.sql.rubrica;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubricaRepository extends CrudRepository<Rubrica, Long> {
}
