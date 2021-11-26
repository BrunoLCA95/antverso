package com.BrunoLCA95.antverso.controller;

import com.BrunoLCA95.antverso.entity.Hormiga;
import com.BrunoLCA95.antverso.service.HormigaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hormiga")
public class HormigaController {
    
    @Autowired
    private HormigaService hormigaService;

    @GetMapping("/{id}")
    public String showHormiga(@PathVariable ("id") String id, Model model){
        model.addAttribute("hormiga", hormigaService.get(id));
        return "hormiga";

    }

    @PostMapping("/nueva/")
    public String saveHormiga(Hormiga hormiga){
        hormigaService.save(hormiga);
        return "/hormiga";
    }


}
