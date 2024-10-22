package com.modulo1.modulo.Servicio.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modulo1.modulo.Modelo.Estudiante;
import com.modulo1.modulo.Repositorio.IEstudianteRepositorio;
import com.modulo1.modulo.Servicio.IEstudianteServicio;

@Service
public class EstudianteServicioImpl implements IEstudianteServicio{
   
    @Autowired
    private IEstudianteRepositorio repositorio;

    @Override
    public List<Estudiante> listarEstudiantes() {
        return repositorio.findAll();
    }

    @Override
    public void guardarEstudiante(Estudiante estudiante) {
        repositorio.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }
    

}
