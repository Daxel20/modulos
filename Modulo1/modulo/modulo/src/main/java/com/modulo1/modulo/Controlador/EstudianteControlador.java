package com.modulo1.modulo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.modulo1.modulo.Modelo.Estudiante;
import com.modulo1.modulo.Servicio.IEstudianteServicio;

@Controller
@RequestMapping("/estudiante")
public class EstudianteControlador {

    @Autowired
    private IEstudianteServicio servicio;

    @GetMapping
    public String mostrarEstudiantes(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("estudiantes", servicio.listarEstudiantes());
        return "estudiante"; // Nombre de la vista (plantilla)
    }

    @PostMapping("/guardarEstudiante")
    public String guardarEstudiante(@ModelAttribute Estudiante estudiante) {
        servicio.guardarEstudiante(estudiante);
        return "redirect:/estudiante";
    }

    @GetMapping("/editar/{idEstudiante}")
    public String editarEstudiante(@PathVariable("idEstudiante") Long id, Model model) {
        Estudiante estudiante = servicio.obtenerEstudiantePorId(id);
        model.addAttribute("estudiante", estudiante != null ? estudiante : new Estudiante());
        model.addAttribute("estudiantes", servicio.listarEstudiantes());
        return "estudiante";
    }

    @GetMapping("/delete/{idEstudiante}")
    public String eliminarEstudiante(@PathVariable("idEstudiante") Long id) {
        servicio.eliminarEstudiante(id);
        return "redirect:/estudiante";
    }
}
