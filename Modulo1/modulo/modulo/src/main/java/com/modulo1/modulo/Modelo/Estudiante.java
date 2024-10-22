package com.modulo1.modulo.Modelo;

import java.io.Serializable;

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
public class Estudiante implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, length=50)
    private Long idEstudiante;
    @Column(name="Nombre", nullable=false, length=50)
    private String nombre;
    @Column(name="Apellido", nullable=false, length=50)
    private String apellido;
    @Column(name="Cedula", nullable=false, length=50)
    private String cedula;
    @Column(name="Email", nullable=false, length=50, unique=true)
    private String correo;
    @Column(name="Telefono", nullable=false, length=50)
    private String telefono;

    public Estudiante(){
        
    }

    public Estudiante(String nombre, String apellido, String cedula, String correo,
            String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
    }
}
