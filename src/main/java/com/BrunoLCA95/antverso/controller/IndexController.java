package com.BrunoLCA95.antverso.controller;

import com.BrunoLCA95.antverso.repository.HormigaRepository;
import com.BrunoLCA95.antverso.repository.PaisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/")
public class IndexController {
    
    @Autowired
    HormigaRepository hormigaRepository;
    @Autowired
    PaisRepository paisRepository;


    @GetMapping("/")
    public String index(ModelMap model){
        model.addAttribute("hormigas", hormigaRepository.findAll());
        model.addAttribute("paises", paisRepository.findAll());
        return "index";
    }

    @PostMapping("/buscar/")
    public String buscar(@RequestParam ("genero") Integer genero, @RequestParam ("pais") Integer pais){
        if (genero >= 1000) {
            return "redirect:/hormiga/hormigaNC/"+genero;
        } else {
            return "redirect:/hormiga/hormigaP/"+pais;
            
        }

    }

    @GetMapping("/login")
	public String login(HttpSession session, Authentication usuario, ModelMap modelo, @RequestParam(required = false) String error) {
		try {
			if (usuario.getName() != null) {
				return "redirect:/";
			} else {
				
				if (error != null && !error.isEmpty()) {
					modelo.addAttribute("error", "El nombre de usuario o la contraseña que ingresó son incorrectas.");
				}
				return "login";
			}
			
		} catch (Exception e) {
			if (error != null && !error.isEmpty()) {
				modelo.addAttribute("error", "El nombre de usuario o la contraseña que ingresó son incorrectas.");
			}
			return "login";
		}
	}
	
	@GetMapping("/loginsuccess")
	public String loginresolver() {
				
		return "redirect:/hormiga/hormigaNC/1010";
	}





}
