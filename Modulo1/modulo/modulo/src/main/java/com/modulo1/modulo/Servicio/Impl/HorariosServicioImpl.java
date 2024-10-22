package com.modulo1.modulo.Servicio.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.modulo1.modulo.Modelo.Horarios;
import com.modulo1.modulo.Repositorio.IHorariosRepositorio;
import com.modulo1.modulo.Servicio.IHorariosServicio;

import java.util.List;

@Service
public class HorariosServicioImpl implements IHorariosServicio {

    @Autowired
    private IHorariosRepositorio repositorio;

    @Override
    public List<Horarios> listarHorarios() {
        return repositorio.findAll();
    }

    @Override
    public void guardarHorario(Horarios horario) {
        repositorio.save(horario);
    }

    @Override
    public Horarios obtenerHorarioPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarHorario(Long id) {
        repositorio.deleteById(id);
    }
}
