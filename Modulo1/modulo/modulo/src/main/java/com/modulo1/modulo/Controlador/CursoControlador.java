package com.modulo1.modulo.Controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.modulo1.modulo.Modelo.Curso;
import com.modulo1.modulo.Servicio.ICursoServicio;
@Controller
@RequestMapping("/curso")
public class CursoControlador {    
    @Autowired    
    private ICursoServicio servicio;
    @GetMapping
    public String mostrarCursos(Model model) {        
        model.addAttribute("curso", new Curso());
        model.addAttribute("cursos", servicio.listarCursos());        
        return "curso";
    }
    @PostMapping("/guardarCurso")    
    public String guardarCurso(@ModelAttribute Curso curso) {
        servicio.guardarCurso(curso);        
        return "redirect:/curso";
    }
    @GetMapping("/editar/{idCurso}")    
    public String editarCurso(@PathVariable("idCurso") Long id, Model model) {
        Curso curso = servicio.obtenerCursoPorId(id);
        model.addAttribute("curso", curso != null ? curso : new Curso());        
        model.addAttribute("cursos", servicio.listarCursos());
        return "curso";    }
    @GetMapping("/delete/{idCurso}")
    public String eliminarCurso(@PathVariable("idCurso") Long id) {        
        servicio.eliminarCurso(id);
        return "redirect:/curso";    }
}