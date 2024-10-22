package com.modulo1.modulo.Servicio;

import com.modulo1.modulo.Modelo.Inscripciones;
import java.util.List;

public interface IInscripcionesServicio {
    List<Inscripciones> listarInscripciones();
    Inscripciones obtenerInscripcionPorId(Long id);
    void guardarInscripcion(Inscripciones inscripcion);
    void eliminarInscripcion(Long id);
}
