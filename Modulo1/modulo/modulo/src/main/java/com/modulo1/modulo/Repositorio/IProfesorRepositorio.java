package com.modulo1.modulo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modulo1.modulo.Modelo.Profesor;

@Repository
public interface IProfesorRepositorio extends JpaRepository<Profesor, Long>{

}
