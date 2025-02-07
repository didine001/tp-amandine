package com.ipi.jva320.controller;

import com.ipi.jva320.exception.SalarieException;
import com.ipi.jva320.exception.SalarieException404;
import com.ipi.jva320.model.SalarieAideADomicile;
import com.ipi.jva320.repository.SalarieAideADomicileRepository;
import com.ipi.jva320.service.SalarieAideADomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SalarieController {
    @Autowired
    private SalarieAideADomicileRepository salarieRepo;
    @Autowired
    private SalarieAideADomicileService salarieAideADomicileService;
    @GetMapping("/salaries")
    public String listeSalaries(
            @RequestParam(required = false) String nom,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "nom") String sortProperty,
            @RequestParam(defaultValue = "ASC") String sortDirection,
            ModelMap model) {

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sortProperty);
        List<SalarieAideADomicile> salarie;
        if (nom != null && !nom.isEmpty()) {
            salarie = salarieAideADomicileService.getSalaries(nom);
            model.put("salaries", salarie);
            model.put("totalPages", 1);
        } else {
            Page<SalarieAideADomicile> salariesPage = salarieRepo.findAll(pageable);
            model.put("salaries", salariesPage.getContent());
            model.put("totalPages", salariesPage.getTotalPages());
        }
        model.put("currentPage", page);
        model.put("size", size);
        model.put("sortProperty", sortProperty);
        model.put("sortDirection", sortDirection);
        model.put("nom", nom);

        return "list";
    }

    @GetMapping("/salaries/{id}")
    public String detailSalarie(@PathVariable Long id, ModelMap model) {
        SalarieAideADomicile salarie = salarieAideADomicileService.getSalarie(id);
        if (salarie == null) {
            throw new SalarieException404("Salarie avec l'ID " + id + " non trouvé");
        }
        model.put("isNew", false);
        model.put("salarie", salarie);
        return "detail_Salarie";
    }

    @GetMapping("/salaries/aide/new")
    public String newSalarie(ModelMap model) {
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        model.put("salarie", salarie);
        model.put("isNew", true);
        return "detail_Salarie";
    }
    @PostMapping("/salaries/save")
        public String saveSalarie(@ModelAttribute SalarieAideADomicile salarie) throws SalarieException {
            SalarieAideADomicile savedSalarie = salarieAideADomicileService.creerSalarieAideADomicile(salarie);
        if (savedSalarie == null || savedSalarie.getId() == null) {
            throw new SalarieException404("Salarie non trouvé après la création");
        }
            return "redirect:/salaries";
    }
    @PostMapping("/salaries/{id}")
    public String updateSalarie(@PathVariable Long id, @ModelAttribute SalarieAideADomicile salarie) throws SalarieException {
        if (id != null && salarieRepo.existsById(id)) {
            salarie.setId(id);
            salarieAideADomicileService.updateSalarieAideADomicile(salarie);
        }
        return "redirect:/salaries";
    }
    @RequestMapping("/salaries/{id}/delete")
    public String deleteSalarie(@PathVariable Long id) throws SalarieException {
        SalarieAideADomicile salarie = salarieAideADomicileService.getSalarie(id);
        if (salarie != null) {
            salarieAideADomicileService.deleteSalarieAideADomicile(id);
        }
        return "redirect:/salaries";
    }
}
