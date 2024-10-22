package com.modulo1.modulo.Servicio;

import java.util.List;

import com.modulo1.modulo.Modelo.Estudiante;

public interface IEstudianteServicio {
    public List<Estudiante>listarEstudiantes();
    //List<Estudiante> obtenerTodos();
    //Estudiante obtenerPorId(Long id);
    //Estudiante guardar(Estudiante estudiante);
    //void eliminar(Long id);
    void guardarEstudiante(Estudiante estudiante);
    void eliminarEstudiante(Long id);
    Estudiante obtenerEstudiantePorId(Long id);

}
