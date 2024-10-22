package com.modulo1.modulo.Modelo;
import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
@Data
@Entity
public class Profesor implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, length=50)
    private Long idProfesor;
    @Column(name="Nombre", nullable=false, length=50)
    private String nombre;
    @Column(name="Apellido", nullable=false, length=50)
    private String apellido;
    @Column(name="Email", nullable=false, length=50, unique=true)
    private String correo;

    private Set<Curso> cursos;

    public Profesor() {
        this.apellido = apellido;
        this.correo = correo;
        this.nombre = nombre;
    }


}
