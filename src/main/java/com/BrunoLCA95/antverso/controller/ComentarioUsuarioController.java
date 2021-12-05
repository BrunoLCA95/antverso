package com.BrunoLCA95.antverso.controller;

import com.BrunoLCA95.antverso.service.ComentarioUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comentarioU")
public class ComentarioUsuarioController {
    @Autowired
    private ComentarioUsuarioService comentarioUsuarioService;

    


}
