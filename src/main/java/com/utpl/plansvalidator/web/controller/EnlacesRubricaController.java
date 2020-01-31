package com.utpl.plansvalidator.web.controller;

import com.utpl.plansvalidator.sql.enlacesrubrica.EnlaceRubricas;
import com.utpl.plansvalidator.sql.enlacesrubrica.EnlaceRubricasRepository;
import com.utpl.plansvalidator.sql.periodo.PeriodoRepository;
import com.utpl.plansvalidator.sql.rubrica.RubricaRepository;
import com.utpl.plansvalidator.web.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;
import java.util.Optional;

@Controller
public class EnlacesRubricaController {
    @Value("${server.servlet.context-path}")
    private String context;

    @Autowired
    private EnlaceRubricasRepository enlaceRubricasRepository;
    @Autowired
    private PeriodoRepository periodoRepository;
    @Autowired
    private RubricaRepository rubricaRepository;

    @GetMapping("/enlaceRubricas")
    public String showEnlacesRubrica(Model model) {
        model.addAttribute("enlaces", enlaceRubricasRepository.findAll());
        model.addAttribute("addEnlaceLink", "/enlaceRubricas/new");
        return "linker/list_enlaces_rubrica";
    }

    @GetMapping("/enlaceRubricas/new")
    public String rubricaLinker(Model model) {
        EnlaceRubricas enlaceRubricas = new EnlaceRubricas();
        if (model.containsAttribute("enlaceRubricas"))
            enlaceRubricas = (EnlaceRubricas) model.getAttribute("enlaceRubricas");
        model.addAttribute("enlaceRubrica", enlaceRubricas);
        model.addAttribute("periodos", periodoRepository.findAll());
        model.addAttribute("rubricas", rubricaRepository.findAll());
        model.addAttribute("action", context + "/enlaceRubricas/add");
        model.addAttribute("actionTitle", "Nuevo enlace");
        model.addAttribute("actionBtn", "Crear");
        return "linker/add_enlace_rubricas";
    }

    @GetMapping("/enlaceRubricas/edit/{id}")
    public String editRubrica(@PathVariable("id") Long id, Model model) {
        Optional<EnlaceRubricas> optionalEnlaceRubricas = enlaceRubricasRepository.findById(id);
        if (!optionalEnlaceRubricas.isPresent())
            throw new ResourceNotFoundException();
        model.addAttribute("enlaceRubricas", optionalEnlaceRubricas.get());
        model.addAttribute("periodos", periodoRepository.findAll());
        model.addAttribute("rubricas", rubricaRepository.findAll());
        model.addAttribute("action", context + "/enlaceRubricas/add");
        model.addAttribute("actionTitle", "Editar Enlace");
        model.addAttribute("actionBtn", "Editar");
        return "linker/add_enlace_rubricas";
    }

    @PostMapping("/enlaceRubricas/add")
    public String addEnlaces(EnlaceRubricas enlaceRubricas, RedirectAttributes redirectAttributes) {
        String succesRedirect = "redirect:/enlaceRubricas";
        String failureRedirect = "redirect:/enlaceRubricas/new";
        // Remove null rubricas
        enlaceRubricas.getRubricas().removeIf(Objects::isNull);
        // Must select at least one 'Rubrica'
        if (enlaceRubricas.getRubricas().isEmpty()) {
            redirectAttributes.addFlashAttribute("enlaceRubricas", enlaceRubricas);
            redirectAttributes.addFlashAttribute("flash",
                    new FlashMessage("Por favor seleccione al menos una rúbrica", FlashMessage.Status.FAILURE));
            return failureRedirect;
        }
        // Save 'enlace'
        enlaceRubricas.getRubricas().forEach(rubrica -> rubrica.setEnlaceRubricas(enlaceRubricas));
        enlaceRubricas.getPeriodo().setEnlaceRubricas(enlaceRubricas);
        enlaceRubricasRepository.save(enlaceRubricas);
        redirectAttributes.addFlashAttribute("flash",
                new FlashMessage("Enlace agregado correctamente", FlashMessage.Status.SUCCESS));
        return succesRedirect;
    }
}
