package com.BrunoLCA95.antverso.controller;

import com.BrunoLCA95.antverso.commons.WebExeption;
import com.BrunoLCA95.antverso.entity.Hormiga;
import com.BrunoLCA95.antverso.repository.HormigaRepository;
import com.BrunoLCA95.antverso.service.HormigaService;
import com.BrunoLCA95.antverso.service.PaisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hormiga")
public class HormigaController {
    
    @Autowired
    private HormigaService hormigaService;

    @Autowired
    private HormigaRepository hormigaRepository;

    @Autowired
    private PaisService paisService;

    @GetMapping("/hormigaNC/{id}")
    public String showById(@PathVariable ("id") Integer id, Model model){


        
        model.addAttribute("hormiga", hormigaRepository.buscarPorId(id));
        model.addAttribute("paisesH", hormigaRepository.buscarPorId(id).getPais());
        return "hormigas";
    }

    @GetMapping("/hormigaP/{id}")
    public String showByPais(@PathVariable ("id") Integer id, Model model){
        model.addAttribute("hormigaP", hormigaRepository.findByPais(paisService.get(id)));
        return "hormigas";
    }

    @GetMapping("/hormiga/{id}")
    public String showSave(@PathVariable ("id") Integer id, Model model){
        model.addAttribute("paises", paisService.getAll());
        if (hormigaRepository.findById(id) != null) {
            model.addAttribute("hormiga", hormigaRepository.findById(id));
        }else{
            model.addAttribute("hormiga", new Hormiga());
        }

        return "hormiga-from";
    }

    @PostMapping("/nueva/")
    public String saveHormiga(Hormiga hormiga, ModelMap model){
        model.addAttribute("paises", paisService.getAll());
        try {
            hormigaService.validation(hormiga);
            hormigaService.save(hormiga);
            model.put("exito", "Hormiga guardada");
        } catch (WebExeption e) {
            model.put("error", e.getMessage());
        }
        return "hormiga-from";
    }

    


}
