package com.inmueble.InmobiliariaSp.servicios;

import com.inmueble.InmobiliariaSp.entidad.Inmueble;
import com.inmueble.InmobiliariaSp.entidad.User;
import com.inmueble.InmobiliariaSp.enumeraciones.TiposInmueble;
import com.inmueble.InmobiliariaSp.excepciones.MiException;
import com.inmueble.InmobiliariaSp.repositorios.InmuebleRepositorio;
import com.inmueble.InmobiliariaSp.repositorios.UserRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class InmuebleServicio {

    @Autowired
    private InmuebleRepositorio inmuebleRepositorio;
    @Autowired
    private UserRepositorio userRepositorio;

    @Transactional
    public void crearInmueble(String id, String direccion, String idDueño, String tiposInmueble) throws MiException {
        validar(id, direccion, idDueño, tiposInmueble);
        Optional<User> respuestaUser = userRepositorio.findById(idDueño);
        User user = new User();
        if (respuestaUser.isPresent()) {
            user = respuestaUser.get();
        }
        Inmueble inmueble = new Inmueble();
        inmueble.setDireccion(direccion);
        inmueble.setDueño(user);
        inmueble.setInquilino(null);
        inmueble.setId(id);
        TiposInmueble[] validar = TiposInmueble.getValues();
        TiposInmueble tipoInmuebleEnum = null;
        for (TiposInmueble tipo : validar) {
            if (tipo.name().equalsIgnoreCase(tiposInmueble)) {
                tipoInmuebleEnum = tipo;
            }
        }
        inmueble.setTiposInmueble(tipoInmuebleEnum);
        inmuebleRepositorio.save(inmueble);
    }

    public List<Inmueble> listarInmuebles() {
        List<Inmueble> inmuebles = new ArrayList();
        inmuebles = inmuebleRepositorio.findAll();
        return inmuebles;
    }

    @Transactional
    public void modificarInmueble(String id, String direccion, String idDueño, String idInquilino, String tiposInmueble) throws MiException {
        validar(id, direccion, idDueño, tiposInmueble);
        Optional<Inmueble> respuesta = inmuebleRepositorio.findById(id);
        Optional<User> respuestaUserDueño = userRepositorio.findById(idDueño);
        Optional<User> respuestaUserInquilino = userRepositorio.findById(idInquilino);
        User userDueño = new User();
        User userInquilino = null;
        if (respuestaUserDueño.isPresent()) {
            userDueño = respuestaUserDueño.get();
        }
        if (respuestaUserInquilino.isPresent()){
            userInquilino = respuestaUserInquilino.get();
        }
        if (respuesta.isPresent()) {
            Inmueble inmueble = respuesta.get();
            inmueble.setDireccion(direccion);
            inmueble.setDueño(userDueño);
            inmueble.setInquilino(userInquilino);
            TiposInmueble[] validar = TiposInmueble.getValues();
            TiposInmueble tipoInmuebleEnum = null;
            for (TiposInmueble tipo : validar) {
                if (tipo.name().equalsIgnoreCase(tiposInmueble)) {
                    tipoInmuebleEnum = tipo;
                }
            }
            inmueble.setTiposInmueble(tipoInmuebleEnum);
            inmuebleRepositorio.save(inmueble);
        }
    }

    public Inmueble getOne(String id) {
        return inmuebleRepositorio.getReferenceById(id);
    }

    private void validar(String id, String direccion, String idDueño, String tiposInmueble) throws MiException {
        if (id.isEmpty() || id == null) {
            throw new MiException("Id no puede ser nulo");
        }
        if (direccion.isEmpty() || direccion == null) {
            throw new MiException("Direccion no puede ser nulo");
        }
        if (idDueño.isEmpty() || idDueño == null) {
            throw new MiException("Direccion no puede ser nulo");
        }
        boolean validacionTiposInmueble = true;
        TiposInmueble[] validar = TiposInmueble.getValues();
        for (TiposInmueble tipo : validar) {
            if (tipo.name().equalsIgnoreCase(tiposInmueble)) {
                validacionTiposInmueble = false;
            }
        }
        if (validacionTiposInmueble) {
            throw new MiException("El tipo de Inmueble no es válido");
        }

    }

}