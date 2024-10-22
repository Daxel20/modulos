package com.modulo1.modulo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modulo1.modulo.Modelo.Inscripciones;

@Repository
public interface IInscripcionesRepositorio extends JpaRepository<Inscripciones, Long>  {

}
