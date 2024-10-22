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
public class Curso implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="Curso", nullable=false, length=50)
    private Long idCurso;
    @Column(name="Nombre", nullable=false, length=50)
    private String nombre;


    public Curso( ) {
        this.nombre = nombre;
    }

    
}
