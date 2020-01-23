package com.utpl.plansvalidator.sql.plandocente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanDocenteRepository extends CrudRepository<PlanDocente, Long> {
}
