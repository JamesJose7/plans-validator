package com.utpl.plansvalidator.web.controller;

import com.utpl.plansvalidator.planes_api.PlanesApiClient;
import com.utpl.plansvalidator.planes_api.PlanesApiService;
import com.utpl.plansvalidator.sql.plandocente.PlanDocente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() throws IOException {
        // TODO: Remove, only for testing
        PlanesApiService planesApiService = PlanesApiClient.getClient().create(PlanesApiService.class);
        PlanDocente planDocente = planesApiService.getPlanDocente(
                "46c50734-4710-008a-e053-ac10360c415f",
                "UTPL-TNCCO0039")
                .execute()
                .body();

        return "index";
    }
}
