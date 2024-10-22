package com.modulo1.modulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.modulo1.modulo.Repositorio.ICursoRepositorio;
import com.modulo1.modulo.Repositorio.IEstudianteRepositorio;
import com.modulo1.modulo.Repositorio.IHorariosRepositorio;
import com.modulo1.modulo.Repositorio.IInscripcionesRepositorio;
import com.modulo1.modulo.Repositorio.IProfesorRepositorio;


@SpringBootApplication
public class ModuloApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ModuloApplication.class, args);
	}

	@Autowired
	private ICursoRepositorio repositorio;
	private IEstudianteRepositorio repositorio2;
	private IHorariosRepositorio repositorio3;
	private IInscripcionesRepositorio repositorio4;
	private IProfesorRepositorio repositorio5;


	@Override
	public void run(String... args) throws Exception{
		/*Curso curso1 = new Curso("Matematicas");
		repositorio.save(curso1);
		Curso curso2 = new Curso("Lenguaje");
		repositorio.save(curso2);
		Estudiante estudiante1= new Estudiante("Daxel","Chicaiza","19049283","dax@gmail.com","0961837263");
		repositorio2.save(estudiante1);
		Estudiante estudiante2= new Estudiante("Dari","Chicaiza","190494563","dari@gmail.com","0961846263");
		repositorio2.save(estudiante2);
		Horarios Horario1 = new Horarios("2","1");
		repositorio3.save(Horario1);
		Horarios Horario2 = new Horarios("1","2");
		repositorio3.save(Horario2);
		Inscripciones inscripcion1 = new Inscripciones("Efectivo", "10/07/2024");
		repositorio4.save(inscripcion1);
		Inscripciones inscripcion2 = new Inscripciones("Efectivo", "10/02/2023");
		repositorio4.save(inscripcion2);
		Profesor profesor1 = new Profesor("Salvador", "sal123@gmail.com", "Agustin");
		repositorio5.save(profesor1);
		Profesor profesor2 = new Profesor("Guaman", "gu132@gmail.com", "Fernado");
		repositorio5.save(profesor2);*/
	}


}
