package com.utpl.plansvalidator.reportes_api;

import com.utpl.plansvalidator.sql.enlacesrubrica.EnlaceRubricas;
import com.utpl.plansvalidator.sql.enlacesrubrica.EnlaceRubricasRepository;
import com.utpl.plansvalidator.sql.periodo.Periodo;
import com.utpl.plansvalidator.sql.periodo.PeriodoRepository;
import com.utpl.plansvalidator.sql.plandocente.Plan;
import com.utpl.plansvalidator.sql.plandocente.PlanRepository;
import com.utpl.plansvalidator.sql.rubrica.Rubrica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ReportesApiService {
    @Autowired
    private EnlaceRubricasRepository enlaceRubricasRepository;
    @Autowired
    private PeriodoRepository periodoRepository;
    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private RubricaValidatorService rubricaValidatorService;

    @GetMapping(value = "/reporte/{periodoId}/{componenteId}")
    public Reporte getReporteRubrica(
            @PathVariable("periodoId") String periodoId,
            @PathVariable("componenteId") int componenteId
    ) {
        Optional<Periodo> periodoOptional = periodoRepository.findByGuid(periodoId);
        if (!periodoOptional.isPresent())
            throw new ResourceNotFoundException("No se encontró el periodo seleccionado");
        Optional<Plan> planOptional = planRepository.findByPeriodoAndComponente(periodoOptional.get(), componenteId);
        if (!planOptional.isPresent())
            throw new ResourceNotFoundException("No se encontró el plan seleccionado");
        Optional<EnlaceRubricas> enlaceRubricasOptional = enlaceRubricasRepository.findByPeriodo(periodoOptional.get());
        if (!enlaceRubricasOptional.isPresent())
            throw new ResourceNotFoundException("No se han adjuntado rúbricas a este período");
        // Get all 'Rubricas' for the current 'Plan
        List<Rubrica> rubricas = enlaceRubricasOptional.get().getRubricas();
        // Run validation
        return rubricaValidatorService.validate(rubricas, planOptional.get());
    }
}
