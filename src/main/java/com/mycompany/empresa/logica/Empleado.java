package com.mycompany.empresa.logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// MartínDCantero
@Entity
public class Empleado implements Serializable {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String cargo;
    private double salario;
    private LocalDate fechaInicio; // Fecha actual

    // Constructor vacío
    public Empleado() {
    }

    // Constructor
    public Empleado(int id, String nombre, String apellido, String cargo, double salario, LocalDate fechaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    // ToString
    @Override
    public String toString() {
        return String.format("| %-3d | %-15s | %-15s | %-20s | %10.2f | %s |",
                id, nombre, apellido, cargo, salario, fechaInicio);
    }

}
