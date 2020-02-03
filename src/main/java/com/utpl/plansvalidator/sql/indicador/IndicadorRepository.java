package com.utpl.plansvalidator.sql.indicador;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicadorRepository extends CrudRepository<Indicador, Long> {
}
