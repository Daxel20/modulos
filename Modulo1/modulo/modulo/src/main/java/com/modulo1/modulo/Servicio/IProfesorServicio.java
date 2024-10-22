package com.modulo1.modulo.Servicio;

import java.util.List;
import com.modulo1.modulo.Modelo.Profesor;

public interface IProfesorServicio {
    List<Profesor> listarProfesores();
    void guardarProfesor(Profesor profesor);
    Profesor obtenerProfesorPorId(Long id);
    void eliminarProfesor(Long id);
}
