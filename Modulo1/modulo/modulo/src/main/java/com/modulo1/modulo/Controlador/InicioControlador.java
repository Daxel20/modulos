package com.modulo1.modulo.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioControlador {
    @GetMapping("/") 
    public String mostrar() { 
        return "index"; 
    } 
}

