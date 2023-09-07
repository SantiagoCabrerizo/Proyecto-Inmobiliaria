package com.inmueble.InmobiliariaSp.servicios;

import com.inmueble.InmobiliariaSp.entidad.Inmueble;
import com.inmueble.InmobiliariaSp.entidad.Transacciones;
import com.inmueble.InmobiliariaSp.enumeraciones.TipoTransaccion;
import com.inmueble.InmobiliariaSp.excepciones.MiException;
import com.inmueble.InmobiliariaSp.repositorios.InmuebleRepositorio;
import com.inmueble.InmobiliariaSp.repositorios.TransaccionesRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrasnsaccionesServicio {

    @Autowired
    private InmuebleRepositorio inmuebleRepositorio;
    @Autowired
    private TransaccionesRepositorio transaccionesRepositorio;

    @Transactional
    public void crearTransacciones(Long id, String idInmueble, String nombre, String tipoTransaccion) throws MiException {
        validar(id, idInmueble, nombre, tipoTransaccion);
        Optional<Inmueble> respuestaInmueble = inmuebleRepositorio.findById(idInmueble);
        Transacciones transacciones = new Transacciones();
        Inmueble inmueble = new Inmueble();
        if (respuestaInmueble.isPresent()) {
            inmueble = respuestaInmueble.get();
        }
        transacciones.setId(id);
        transacciones.setInmueble(inmueble);
        transacciones.setNombre(nombre);

        TipoTransaccion[] validar = TipoTransaccion.getValues();
        TipoTransaccion tipoTransaccionEnum = null;
        for (TipoTransaccion tipo : validar) {
            if (tipo.name().equalsIgnoreCase(tipoTransaccion)) {
                tipoTransaccionEnum = tipo;
            }
        }
        transacciones.setTipoTransaccion(tipoTransaccionEnum);
        transaccionesRepositorio.save(transacciones);
    }

    @Transactional
    public void modificarTransacciones(Long id, String idInmueble, String nombre, String tipoTransaccion) throws MiException {
        validar(id, idInmueble, nombre, tipoTransaccion);
        Optional<Transacciones> respuesta = transaccionesRepositorio.findById(id);
        Optional<Inmueble> respuestaInmueble = inmuebleRepositorio.findById(idInmueble);
        Inmueble inmueble = new Inmueble();
        if (respuestaInmueble.isPresent()) {
            inmueble = respuestaInmueble.get();
        }
        if (respuesta.isPresent()) {
            Transacciones transacciones = new Transacciones();
            transacciones.setId(id);
            transacciones.setInmueble(inmueble);
            transacciones.setNombre(nombre);
            TipoTransaccion[] validar = TipoTransaccion.getValues();
            TipoTransaccion tipoTransaccionEnum = null;
            for (TipoTransaccion tipo : validar) {
                if (tipo.name().equalsIgnoreCase(tipoTransaccion)) {
                    tipoTransaccionEnum = tipo;
                }
            }
            transacciones.setTipoTransaccion(tipoTransaccionEnum);
            transaccionesRepositorio.save(transacciones);

        }

    }

    public List<Transacciones> listarTransacciones() {
        List<Transacciones> transacciones = new ArrayList();
        transacciones = transaccionesRepositorio.findAll();
        return transacciones;
    }

    public Transacciones getOne(Long id) {
        return transaccionesRepositorio.getOne(id);
    }

    private void validar(Long id, String idInmueble, String nombre, String tipoTransaccion) throws MiException {
        if (id == null) {
            throw new MiException("Id no puede ser nulo");
        }
        if (idInmueble.isEmpty() || idInmueble == null) {
            throw new MiException("Id inmueble no puede ser nulo");
        }
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("nombre no puede ser nulo");
        }

        boolean validacionTipoTransaccion = true;
        TipoTransaccion[] validar = TipoTransaccion.getValues();
        for (TipoTransaccion tipo : validar) {
            if (tipo.name().equalsIgnoreCase(tipoTransaccion)) {
                validacionTipoTransaccion = false;
            }
        }
        if (validacionTipoTransaccion) {
            throw new MiException("El tipo de transaccion no es válido");
        }

    }
}
