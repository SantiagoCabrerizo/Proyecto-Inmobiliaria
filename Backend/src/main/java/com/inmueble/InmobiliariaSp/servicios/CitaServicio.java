/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inmueble.InmobiliariaSp.servicios;

import com.inmueble.InmobiliariaSp.entidad.Cita;
import com.inmueble.InmobiliariaSp.entidad.Inmueble;
import com.inmueble.InmobiliariaSp.entidad.User;
import com.inmueble.InmobiliariaSp.excepciones.MiException;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.stereotype.Service;

@Service
public class CitaServicio {
    
    public void crearCitas(Inmueble inmueble, LocalDate dia, LocalTime horarioInicio, LocalTime horarioFin) throws MiException {
        User user = inmueble.getDueño();
        for (int i = 0; horarioInicio.isBefore(horarioFin); i++) {
            Cita cita = new Cita();
            cita.setDia(dia);
            cita.setDueño(user);
            cita.setInmueble(inmueble);
            cita.setHorario(horarioInicio);
            horarioInicio = horarioFin.plusMinutes(30);
        }
    }
        
}