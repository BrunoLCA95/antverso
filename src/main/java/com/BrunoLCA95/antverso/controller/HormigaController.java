package com.BrunoLCA95.antverso.controller;

import java.util.ArrayList;
import java.util.List;

import com.BrunoLCA95.antverso.commons.WebExeption;
import com.BrunoLCA95.antverso.entity.ComentarioUsuario;
import com.BrunoLCA95.antverso.entity.Hormiga;
import com.BrunoLCA95.antverso.entity.Pais;
import com.BrunoLCA95.antverso.repository.ComentarioUsuarioRepository;
import com.BrunoLCA95.antverso.repository.HormigaRepository;
import com.BrunoLCA95.antverso.repository.PaisRepository;
import com.BrunoLCA95.antverso.repository.UsuarioRepository;
import com.BrunoLCA95.antverso.service.ComentarioUsuarioService;
import com.BrunoLCA95.antverso.service.EstadoService;
import com.BrunoLCA95.antverso.service.HormigaService;
import com.BrunoLCA95.antverso.service.PaisService;
import com.google.sitebricks.http.Get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/hormiga")
public class HormigaController {
    
    @Autowired
    private HormigaService hormigaService;

    @Autowired
    private HormigaRepository hormigaRepository;

    @Autowired
    private PaisService paisService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private ComentarioUsuarioRepository comentarioUsuarioRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/hormigaNC/{id}")
    public String showById(@PathVariable ("id") Integer id, Model model){      
        model.addAttribute("hormiga", hormigaRepository.buscarPorId(id));
        model.addAttribute("paisesH", hormigaRepository.buscarPorId(id).getPais());
        model.addAttribute("comentarios", comentarioUsuarioRepository.findByHormiga(hormigaRepository.buscarPorId(id)));
        return "hormigas";
    }

    @GetMapping("/hormigaP/{id}")
    public String showByPais(@PathVariable ("id") Integer id, Model model){
        Pais pais = paisRepository.buscarPais(id);

        model.addAttribute("pais", pais);

        List<Hormiga> hormigasP = new ArrayList<>();

        for (Hormiga hormiga : hormigaRepository.findAll()) {
            for (Pais pais2 : hormiga.getPais()) {
                if (pais.equals(pais2)) {
                    hormigasP.add(hormiga);
                }
            }
        }

        model.addAttribute("hormigaP", hormigasP);
        return "hormiga-pais";
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
    public String saveHormiga(Hormiga hormiga, ModelMap model, @RequestParam("file") MultipartFile imagen ){
        model.addAttribute("paises", paisService.getAll());
        try {
            hormiga = hormigaService.saveImg(imagen, hormiga);
            hormigaService.save(hormiga);
            model.put("exito", "Hormiga guardada");
        } catch (WebExeption e) {
            model.put("error", e.getMessage());
        }
        return "hormiga-from";
    }

    @GetMapping("/comentario/{id}")
    public String ShowComentario( @PathVariable ("id") Integer id, Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
        userDetails = (UserDetails) principal;
        }
        try {
            if (userDetails.getUsername() != null) {
                model.addAttribute("paises", paisService.getAll());
                model.addAttribute("estados", estadoService.getAll());
    
                ComentarioUsuario comentario = new ComentarioUsuario();
                comentario.setHormiga(hormigaRepository.buscarPorId(id));
                model.addAttribute("comentario", comentario);
    
                return "comentario-from";
            }            
        } catch (Exception e) {
            return "redirect:/login";
        }



        if (userDetails.getUsername() != null) {
            model.addAttribute("paises", paisService.getAll());
            model.addAttribute("estados", estadoService.getAll());

            ComentarioUsuario comentario = new ComentarioUsuario();
            comentario.setHormiga(hormigaRepository.buscarPorId(id));
            model.addAttribute("comentario", comentario);

            return "comentario-from";    

        }else{

            return "login";
        }
        
    }

    @PostMapping("/comentario/")
    public String saveComentario(ComentarioUsuario com, ModelMap model) throws WebExeption{        
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
        userDetails = (UserDetails) principal;
        }
        com.setUsuario(usuarioRepository.findByNombre(userDetails.getUsername()));
        comentarioUsuarioRepository.save(com);
        
        return "redirect:/hormiga/hormigaNC/"+com.getHormiga().getId();
    }

}
