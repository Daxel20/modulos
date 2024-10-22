package com.modulo1.modulo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.modulo1.modulo.Modelo.Horarios;
import com.modulo1.modulo.Servicio.IHorariosServicio;

@Controller
@RequestMapping("/horario")
public class HorariosControlador {

    @Autowired
    private IHorariosServicio servicio;

    @GetMapping
    public String mostrarHorarios(Model model) {
        model.addAttribute("horario", new Horarios());
        model.addAttribute("horarios", servicio.listarHorarios());
        return "horario"; // Nombre de la vista (plantilla)
    }

    @PostMapping("/guardarHorario")
    public String guardarHorario(@ModelAttribute Horarios horario) {
        servicio.guardarHorario(horario);
        return "redirect:/horario";
    }

    @GetMapping("/editar/{idHorarios}")
    public String editarHorario(@PathVariable("idHorarios") Long id, Model model) {
        Horarios horario = servicio.obtenerHorarioPorId(id);
        model.addAttribute("horario", horario != null ? horario : new Horarios());
        model.addAttribute("horarios", servicio.listarHorarios());
        return "horario";
    }

    @GetMapping("/delete/{idHorarios}")
    public String eliminarHorario(@PathVariable("idHorarios") Long id) {
        servicio.eliminarHorario(id);
        return "redirect:/horario";
    }
}
