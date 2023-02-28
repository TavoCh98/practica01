package com.Estado.controller;

import com.Estado.domain.Estado;
import com.Estado.service.EstadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    EstadoService estadoService;
    
    @GetMapping("/")
    public String page(Model model) {
        log.info("Ahora estás conectado con la base de datos práctica");
        var estados = estadoService.getEstados();
        model.addAttribute("estados", estados);

        return "index";
    }
    
    @GetMapping("/nuevoEstado")
    public String nuevoEstado(Estado estado) {
        return "modificarEstado";
    }
    
    @PostMapping("/salvarEstado")
    public String salvarEstado(Estado estado) {
        estadoService.save(estado);
        return "redirect:/";
    }
    
    @GetMapping("/modificarEstado/{idEstado}")
    
    public String modificarEstado(Estado estado, Model model) {
        estado = estadoService.getEstado(estado);
        model.addAttribute("estado", estado);
        return "modificarEstado";
    }

    @GetMapping("/eliminarEstado/{idEstado}")
    public String eliminarEstado(Estado estado) {
        estadoService.delete(estado);
        return "redirect:/";
    }
    
}