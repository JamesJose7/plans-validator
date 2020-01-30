package com.utpl.plansvalidator.sql.restriccionrubrica;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestriccionRubricaRepository extends CrudRepository<RestriccionRubrica, Long> {
}
