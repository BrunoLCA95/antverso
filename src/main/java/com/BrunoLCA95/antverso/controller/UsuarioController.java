package com.BrunoLCA95.antverso.controller;

import com.BrunoLCA95.antverso.commons.WebExeption;
import com.BrunoLCA95.antverso.entity.Usuario;
import com.BrunoLCA95.antverso.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registration")
    public String formRegistration(Model model){
        return "user-registration";
    }

    @PostMapping("/registration")
    public String saveUser(@RequestParam String nombre, @RequestParam String email, @RequestParam String contraseña, @RequestParam String contraseñaV, ModelMap model){
        Usuario user = new Usuario();
        user.setNombre(nombre);
        user.setEmail(email);
        user.setContraseña(contraseña);
        
        if (contraseña.equals(contraseñaV)) {

            try {
                usuarioService.save(user);
                model.put("exito", "Registro Exitoso");
                return "user-registration";
            } catch (WebExeption e) {
                model.put("error", e.getMessage());
                return "user-registration";
            }

        }else{
            model.put("error", "Las contraseñas no coinciden");
            return "user-registration";
        }        
    }


}
