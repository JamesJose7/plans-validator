package com.utpl.plansvalidator.sql.enlacesrubrica;

import com.utpl.plansvalidator.sql.plandocente.PlanDocente;
import com.utpl.plansvalidator.sql.rubrica.Rubrica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnlacesRubricaRepository extends CrudRepository<EnlacesRubrica, Long> {
    List<EnlacesRubrica> findAllByRubrica(Rubrica rubrica);
    List<EnlacesRubrica> findAllByPlanDocente(PlanDocente planDocente);
}
