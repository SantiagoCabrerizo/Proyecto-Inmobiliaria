/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inmueble.InmobiliariaSp.entidad;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author 4rm4c
 */
@Entity
public class Cita {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @ManyToOne
    private Inmueble inmueble;
    private LocalDate dia;
    private LocalTime horario;
    @ManyToOne
    private User dueño;
    @ManyToOne
    private User inquilino;

    public Cita() {
    }

    public Cita(Inmueble inmueble, LocalDate dia, LocalTime horario, User dueño, User inquilino) {
        this.inmueble = inmueble;
        this.dia = dia;
        this.horario = horario;
        this.dueño = dueño;
        this.inquilino = inquilino;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public User getDueño() {
        return dueño;
    }

    public void setDueño(User dueño) {
        this.dueño = dueño;
    }

    public User getInquilino() {
        return inquilino;
    }

    public void setInquilino(User inquilino) {
        this.inquilino = inquilino;
    }
    
}