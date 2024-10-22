package com.modulo1.modulo.Servicio;

import java.util.List;

import com.modulo1.modulo.Modelo.Curso;

public interface ICursoServicio {

    public List<Curso>listarCursos();
    //List<Curso> obtenerTodos();
    //Curso obtenerPorId(Long id);
    //Curso guardar(Curso curso);
    //void eliminar(Long id);

     void guardarCurso(Curso curso);

     void eliminarCurso(Long id);

     Curso obtenerCursoPorId(Long id);


    

}
