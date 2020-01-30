package com.utpl.plansvalidator.sql.periodo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoRepository extends CrudRepository<Periodo, Long> {
}
