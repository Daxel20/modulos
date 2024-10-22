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

public class Horarios implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, length=50)
    private Long idHorarios;
    @Column(name="Horas", nullable=false, length=50)
    private String Horas;
    @Column(name="Dias", nullable=false, length=50)
    private String Dias;


    public Horarios() {
        this.Dias = Dias;
        this.Horas = Horas;
    }


}
