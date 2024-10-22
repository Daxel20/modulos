package com.modulo1.modulo.Servicio.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.modulo1.modulo.Modelo.Profesor;
import com.modulo1.modulo.Repositorio.IProfesorRepositorio;
import com.modulo1.modulo.Servicio.IProfesorServicio;

import java.util.List;

@Service
public class ProfesorServicioImpl implements IProfesorServicio {

    @Autowired
    private IProfesorRepositorio repositorio;

    @Override
    public List<Profesor> listarProfesores() {
        return repositorio.findAll();
    }

    @Override
    public void guardarProfesor(Profesor profesor) {
        repositorio.save(profesor);
    }

    @Override
    public Profesor obtenerProfesorPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarProfesor(Long id) {
        repositorio.deleteById(id);
    }
}

