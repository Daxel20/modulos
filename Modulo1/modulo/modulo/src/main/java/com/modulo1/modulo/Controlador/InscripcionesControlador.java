package com.modulo1.modulo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.modulo1.modulo.Modelo.Inscripciones;
import com.modulo1.modulo.Servicio.IInscripcionesServicio;

@Controller
@RequestMapping("/inscripcion")
public class InscripcionesControlador {

    @Autowired
    private IInscripcionesServicio servicio;

    @GetMapping
    public String mostrarInscripciones(Model model) {
        model.addAttribute("inscripcion", new Inscripciones());
        model.addAttribute("inscripciones", servicio.listarInscripciones());
        return "inscripcion";
    }

    @PostMapping("/guardarInscripcion")
    public String guardarInscripcion(@ModelAttribute Inscripciones inscripcion) {
        servicio.guardarInscripcion(inscripcion);
        return "redirect:/inscripcion";
    }

    @GetMapping("/editar/{idInscripciones}")
    public String editarInscripcion(@PathVariable("idInscripciones") Long id, Model model) {
        Inscripciones inscripcion = servicio.obtenerInscripcionPorId(id);
        model.addAttribute("inscripcion", inscripcion != null ? inscripcion : new Inscripciones());
        model.addAttribute("inscripciones", servicio.listarInscripciones());
        return "inscripcion";
    }

    @GetMapping("/delete/{idInscripciones}")
    public String eliminarInscripcion(@PathVariable("idInscripciones") Long id) {
        servicio.eliminarInscripcion(id);
        return "redirect:/inscripcion";
    }
}
