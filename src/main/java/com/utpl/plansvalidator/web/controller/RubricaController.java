package com.utpl.plansvalidator.web.controller;

import com.utpl.plansvalidator.custom_queries.CustomResultList;
import com.utpl.plansvalidator.custom_queries.PlanDocenteQueryResolver;
import com.utpl.plansvalidator.sql.indicador.Indicador;
import com.utpl.plansvalidator.sql.rubrica.Rubrica;
import net.sf.jsqlparser.JSQLParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RubricaController {
    @Value("${server.servlet.context-path}")
    private String context;

    @Autowired
    private PlanDocenteQueryResolver planDocenteQueryResolver;

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

    @GetMapping("rubricas/temp")
    public String tempRubricaResult(Model model) {
        if (model.containsAttribute("rubrica")) {
            Rubrica rubrica = (Rubrica) model.getAttribute("rubrica");
            model.addAttribute("rubrica", rubrica);
        }
        if (model.containsAttribute("results")) {
            List<CustomResultList> results = (List<CustomResultList>) model.getAttribute("results");
            model.addAttribute("results", results);
        }
        return "rubrica/rubrica_temp_result";
    }

    @PostMapping("/rubricas/add")
    public String addRubrica(@Valid Rubrica rubrica, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("rubrica", rubrica);
        // Validate
        List<Indicador> indicadores = rubrica.getIndicadores();
        List<CustomResultList> indicatorsResults = indicadores.stream()
                .map(indicador -> {
                    // Execute Query and get the resulting object
                    CustomResultList result;
                    try {
                        result = planDocenteQueryResolver.executeQuery(indicador.getFuncion(), indicador.getCondicion());
                    } catch (JSQLParserException | SQLSyntaxErrorException e) {
                        e.printStackTrace();
                        result = new CustomResultList();
                    }
                    return result;
                })
                .collect(Collectors.toList());
        redirectAttributes.addFlashAttribute("results", indicatorsResults);
//        return "redirect:/rubricas/new";
        return "redirect:/rubricas/temp";
    }
}
