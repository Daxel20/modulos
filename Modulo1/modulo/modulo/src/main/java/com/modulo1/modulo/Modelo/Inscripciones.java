package com.modulo1.modulo.Modelo;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

public class Inscripciones implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long idInscripciones;
    private String tipoPago;
    private java.sql.Date fechaInscripcion; // Usamos java.sql.Date

    // Constructor que acepta dos cadenas como parámetros
    public Inscripciones() {
        this.tipoPago = tipoPago;

    }

    // Getters y Setters
    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public java.sql.Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(java.sql.Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public String toString() {
        return "Inscripciones{" +
                "tipoPago='" + tipoPago + '\'' +
                ", fechaInscripcion=" + fechaInscripcion +
                '}';
    }
}
