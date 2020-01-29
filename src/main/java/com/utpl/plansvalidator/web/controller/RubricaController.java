package com.utpl.plansvalidator.web.controller;

import com.utpl.plansvalidator.custom_queries.CustomResultList;
import com.utpl.plansvalidator.custom_queries.PlanDocenteQueryResolver;
import com.utpl.plansvalidator.sql.indicador.Indicador;
import com.utpl.plansvalidator.sql.indicador.IndicadorRepository;
import com.utpl.plansvalidator.sql.rubrica.Rubrica;
import com.utpl.plansvalidator.sql.rubrica.RubricaRepository;
import com.utpl.plansvalidator.web.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class RubricaController {
    @Value("${server.servlet.context-path}")
    private String context;

    @Autowired
    private PlanDocenteQueryResolver planDocenteQueryResolver;
    @Autowired
    private RubricaRepository rubricaRepository;
    @Autowired
    private IndicadorRepository indicadorRepository;

    @GetMapping("/rubricas")
    public String showRubricas(Model model) {
        model.addAttribute("rubricas", rubricaRepository.findAll());
        model.addAttribute("addNewRubricaLink", "/rubricas/new");
        return "rubrica/list_rubricas";
    }

    @GetMapping("/rubricas/new")
    public String addRubricaForm(Model model) {
        Rubrica rubrica = new Rubrica();
        rubrica.setIndicadores(new ArrayList<>(Collections.singletonList(new Indicador())));
        if (model.containsAttribute("rubrica"))
            rubrica = (Rubrica) model.getAttribute("rubrica");
        model.addAttribute("rubrica", rubrica);
        model.addAttribute("action", context + "/rubricas/add");
        model.addAttribute("actionTitle", "Nueva Rúbrica");
        model.addAttribute("actionBtn", "Crear");
        return "rubrica/add_rubrica";
    }

    @GetMapping("/rubricas/edit/{id}")
    public String editRubrica(@PathVariable("id") Long id, Model model) {
        Optional<Rubrica> optionalRubrica = rubricaRepository.findById(id);
        if (!optionalRubrica.isPresent())
            throw new ResourceNotFoundException();
        model.addAttribute("rubrica", optionalRubrica.get());
        model.addAttribute("action", context + "/rubricas/add");
        model.addAttribute("actionTitle", "Editar Rúbrica");
        model.addAttribute("actionBtn", "Editar");
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
    public String addRubrica(@Valid Rubrica rubrica, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.rubrica", result);
            redirectAttributes.addFlashAttribute("rubrica", rubrica);
            return "redirect:/rubricas/new";
        }
        rubrica.getIndicadores().forEach(indicador -> indicador.setRubrica(rubrica));
        rubricaRepository.save(rubrica);
        redirectAttributes.addFlashAttribute("flash", new FlashMessage("Rúbrica agregada correctamente", FlashMessage.Status.SUCCESS));
        return "redirect:/rubricas";

        // TODO: Move to validator
        // Validate
        /*List<Indicador> indicadores = rubrica.getIndicadores();
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
        redirectAttributes.addFlashAttribute("results", indicatorsResults);*/
        // Save Rubrica
    }
}
