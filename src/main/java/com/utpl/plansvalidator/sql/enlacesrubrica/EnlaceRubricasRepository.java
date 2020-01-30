package com.utpl.plansvalidator.sql.enlacesrubrica;

import com.utpl.plansvalidator.sql.periodo.Periodo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnlaceRubricasRepository extends CrudRepository<EnlaceRubricas, Long> {
    Optional<EnlaceRubricas> findByPeriodo(Periodo periodo);
}
