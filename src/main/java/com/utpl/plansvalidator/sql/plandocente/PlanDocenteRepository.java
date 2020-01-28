package com.utpl.plansvalidator.sql.plandocente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanDocenteRepository extends CrudRepository<PlanDocente, Long> {
    Optional<PlanDocente> findByComponente(String componente);
}
