package com.utpl.plansvalidator.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StartupConfig {
    private static Logger logger = LoggerFactory.getLogger(StartupConfig.class.getName());


    @EventListener(ContextRefreshedEvent.class)
    public void bootConfiguration() throws IOException {
        // Plan docente for testing
        /*PlanesApiService planesApiService = PlanesApiClient.getClient().create(PlanesApiService.class);
        String periodo = "46c50734-4710-008a-e053-ac10360c415f";
        String componente = "UTPL-TNCCO0039";
        PlanDocente planDocente = planesApiService.getPlanDocente(
                periodo,
                componente)
                .execute()
                .body();
        if (planDocente != null) {
            planDocente.setComponente(componente);
            planDocente.setPeriodo(periodo);
            Optional<PlanDocente> optionalPlanDocente = planDocenteRepository.findByComponente(componente);
            if (!optionalPlanDocente.isPresent())
                planDocenteRepository.save(planDocente);
        }*/
    }
}
