package com.utpl.plansvalidator.sql.indicador;

import com.utpl.plansvalidator.sql.rubrica.Rubrica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndicadorRepository extends CrudRepository<Indicador, Long> {
    List<Indicador> findAllByRubrica(Rubrica rubrica);
}
