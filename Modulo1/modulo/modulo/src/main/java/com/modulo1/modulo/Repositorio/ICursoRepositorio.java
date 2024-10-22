package com.modulo1.modulo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modulo1.modulo.Modelo.Curso;

@Repository
public interface ICursoRepositorio extends JpaRepository<Curso, Long>{

}
