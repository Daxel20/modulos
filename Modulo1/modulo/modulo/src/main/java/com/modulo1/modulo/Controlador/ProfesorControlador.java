package com.modulo1.modulo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.modulo1.modulo.Modelo.Profesor;
import com.modulo1.modulo.Servicio.IProfesorServicio;

@Controller
@RequestMapping("/profesor")
public class ProfesorControlador {

    @Autowired
    private IProfesorServicio servicio;

    @GetMapping
    public String mostrarProfesores(Model model) {
        model.addAttribute("profesor", new Profesor());
        model.addAttribute("profesores", servicio.listarProfesores());
        return "profesor";
    }

    @PostMapping("/guardarProfesor")
    public String guardarProfesor(@ModelAttribute Profesor profesor) {
        servicio.guardarProfesor(profesor);
        return "redirect:/profesor";
    }

    @GetMapping("/editar/{idProfesor}")
    public String editarProfesor(@PathVariable("idProfesor") Long id, Model model) {
        Profesor profesor = servicio.obtenerProfesorPorId(id);
        model.addAttribute("profesor", profesor != null ? profesor : new Profesor());
        model.addAttribute("profesores", servicio.listarProfesores());
        return "profesor";
    }

    @GetMapping("/delete/{idProfesor}")
    public String eliminarProfesor(@PathVariable("idProfesor") Long id) {
        servicio.eliminarProfesor(id);
        return "redirect:/profesor";
    }
}
