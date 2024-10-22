package com.modulo1.modulo.Servicio;

import com.modulo1.modulo.Modelo.Horarios;
import java.util.List;

public interface IHorariosServicio {
    List<Horarios> listarHorarios();
    void guardarHorario(Horarios horario);
    Horarios obtenerHorarioPorId(Long id);
    void eliminarHorario(Long id);
}
