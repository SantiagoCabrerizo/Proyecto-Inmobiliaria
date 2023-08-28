package com.inmueble.InmobiliariaSp.servicios;

import com.inmueble.InmobiliariaSp.entidad.Inmueble;
import com.inmueble.InmobiliariaSp.entidad.User;
import com.inmueble.InmobiliariaSp.enumeraciones.TipoNegocio;
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
    public void crearInmueble(Inmueble inmueble, String idDueño) throws MiException {
        validar(inmueble, idDueño);
        Optional<User> respuestaUser = userRepositorio.findById(idDueño);
        User user = respuestaUser.get();
        Inmueble inmuebleAGuardar = new Inmueble();
        inmuebleAGuardar.setDireccion(inmueble.getDireccion());
        inmuebleAGuardar.setDueño(user);
        inmuebleAGuardar.setTiposInmueble(inmueble.getTiposInmueble());
        inmuebleRepositorio.save(inmueble);
    }

    public List<Inmueble> listarInmuebles() {
        List<Inmueble> inmuebles = new ArrayList();
        inmuebles = inmuebleRepositorio.findAll();
        return inmuebles;
    }
    
    public List<Inmueble> listarInmueblesPorDueño(User dueño) {
        return inmuebleRepositorio.findByDueño(dueño);
    }

//    @Transactional
//    public void modificarInmueble(String id, String direccion, String idDueño, String idInquilino, String tiposInmueble) throws MiException {
//        validar(id, direccion, idDueño, tiposInmueble);
//        Optional<Inmueble> respuesta = inmuebleRepositorio.findById(id);
//        Optional<User> respuestaUserDueño = userRepositorio.findById(idDueño);
//        Optional<User> respuestaUserInquilino = userRepositorio.findById(idInquilino);
//        User userDueño = new User();
//        User userInquilino = null;
//        if (respuestaUserDueño.isPresent()) {
//            userDueño = respuestaUserDueño.get();
//        }
//        if (respuestaUserInquilino.isPresent()){
//            userInquilino = respuestaUserInquilino.get();
//        }
//        if (respuesta.isPresent()) {
//            Inmueble inmueble = respuesta.get();
//            inmueble.setDireccion(direccion);
//            inmueble.setDueño(userDueño);
//            inmueble.setInquilino(userInquilino);
//            TiposInmueble[] validar = TiposInmueble.getValues();
//            TiposInmueble tipoInmuebleEnum = null;
//            for (TiposInmueble tipo : validar) {
//                if (tipo.name().equalsIgnoreCase(tiposInmueble)) {
//                    tipoInmuebleEnum = tipo;
//                }
//            }
//            inmueble.setTiposInmueble(tipoInmuebleEnum);
//            inmuebleRepositorio.save(inmueble);
//        }
//    }

    public Inmueble getOne(String id) {
        return inmuebleRepositorio.getReferenceById(id);
    }

    private void validar(Inmueble inmueble, String idDueño) throws MiException {
        if (idDueño == null) {
            throw new MiException("El id de dueño no puede ser nulo");
        } else {
            Optional<User> respuestaUser = userRepositorio.findById(idDueño);
            if(!respuestaUser.isPresent()){
                throw new MiException("El id de dueño es incorrecto");
            }
        }
        if (isDireccionUnique(inmueble.getDireccion())) {
            throw new MiException("La direccion ya se encuentra registrado.");
        }
        if (inmueble.getDireccion()== null || inmueble.getDireccion().isEmpty()) {
            throw new MiException("No se ha procesado la direccion");
        }
        boolean validarTiposInmueble = true;
        TiposInmueble[] validarTInmueble = TiposInmueble.getValues();
        for (TiposInmueble tipo : validarTInmueble) {
            if (tipo.equals(inmueble.getTiposInmueble())) {
                validarTiposInmueble = false;
            }
        }
        if (validarTiposInmueble) {
            throw new MiException("El tipo de inmueble no es válido");
        }  
    }
    
    public boolean isDireccionUnique(String direccion) {
        Inmueble existingInmueble = inmuebleRepositorio.findByDireccion(direccion);
        return existingInmueble != null;
    }

}