package com.utpl.plansvalidator.sql.plandocente;

import com.utpl.plansvalidator.sql.periodo.Periodo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends CrudRepository<Plan, Long> {
    List<Plan> findAllByPeriodo(Periodo periodo);
}
