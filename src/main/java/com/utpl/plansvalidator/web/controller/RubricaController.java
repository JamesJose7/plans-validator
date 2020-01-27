package com.utpl.plansvalidator.web.controller;

import com.utpl.plansvalidator.sql.indicador.Indicador;
import com.utpl.plansvalidator.sql.rubrica.Rubrica;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;

@Controller
public class RubricaController {
    @Value("${server.servlet.context-path}")
    private String context;

    @GetMapping("/rubricas/new")
    public String addRubricaForm(Model model) {
        Rubrica rubrica = new Rubrica();
        rubrica.setIndicadores(new ArrayList<>(Collections.singletonList(new Indicador())));
        if (model.containsAttribute("rubrica"))
            rubrica = (Rubrica) model.getAttribute("rubrica");
        model.addAttribute("rubrica", rubrica);
        model.addAttribute("action", context + "/rubricas/add");
        return "rubrica/add_rubrica";
    }

    @PostMapping("/rubricas/add")
    public String addRubrica(@Valid Rubrica rubrica, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("rubrica", rubrica);
        return "redirect:/rubricas/new";
    }
}
