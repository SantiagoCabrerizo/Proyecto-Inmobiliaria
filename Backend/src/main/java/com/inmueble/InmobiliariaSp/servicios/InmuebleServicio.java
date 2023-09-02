package com.inmueble.InmobiliariaSp.servicios;

import com.inmueble.InmobiliariaSp.contenedores.InmuebleForm;
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

    @Transactional
    public Inmueble crearInmuebleDesdeInmuebleForm(InmuebleForm inmuebleForm, String userId) throws MiException {
        System.out.println(inmuebleForm.toString());
        validar(inmuebleForm, userId);
        Inmueble inmueble = new Inmueble();
        inmueble.setDireccion(inmuebleForm.getDireccion());
        inmueble.setDueño(userRepositorio.getReferenceById(userId));
        inmueble.setCaracteristicas(inmuebleForm.getCaracteristicas());
        TiposInmueble[] validarTiposInmueble = TiposInmueble.getValues();
        for (TiposInmueble tipo : validarTiposInmueble) {
            if (tipo.toString().equalsIgnoreCase(inmuebleForm.getTiposInmueble())) {
                inmueble.setTiposInmueble(tipo);
            }
        }
        TipoNegocio[] validarTipoNegocio = TipoNegocio.getValues();
        for (TipoNegocio tipo : validarTipoNegocio) {
            if (tipo.toString().equalsIgnoreCase(inmuebleForm.getTipoNegocio())) {
                inmueble.setTipoNegocio(tipo);
            }
        }
        inmueble.setValor(Integer.parseInt(inmuebleForm.getValor()));
        return inmuebleRepositorio.save(inmueble);
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
            if (!respuestaUser.isPresent()) {
                throw new MiException("El id de dueño es incorrecto");
            }
        }
        if (isDireccionUnique(inmueble.getDireccion())) {
            throw new MiException("La direccion ya se encuentra registrado.");
        }
        if (inmueble.getDireccion() == null || inmueble.getDireccion().isEmpty()) {
            throw new MiException("No se ha procesado la direccion");
        }
        if (inmueble.getCaracteristicas() == null || inmueble.getCaracteristicas().isEmpty()) {
            throw new MiException("No se han procesado las caracteristicas");
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

    private void validar(InmuebleForm inmuebleForm, String userId) throws MiException {
        if (userId == null) {
            throw new MiException("El id de dueño no puede ser nulo");
        } else {
            Optional<User> respuestaUser = userRepositorio.findById(userId);
            if (!respuestaUser.isPresent()) {
                throw new MiException("El id de dueño es incorrecto");
            }
        }
        if (isDireccionUnique(inmuebleForm.getDireccion())) {
            throw new MiException("La direccion ya se encuentra registrado.");
        }
        if (inmuebleForm.getDireccion() == null || inmuebleForm.getDireccion().isEmpty()) {
            throw new MiException("No se ha procesado la direccion");
        }
        if (inmuebleForm.getCaracteristicas() == null || inmuebleForm.getCaracteristicas().isEmpty()) {
            throw new MiException("No se han procesado las caracteristicas");
        }
        boolean validarTiposInmueble = true;
        TiposInmueble[] validarTInmueble = TiposInmueble.getValues();
        for (TiposInmueble tipo : validarTInmueble) {
            System.out.println(tipo.toString() + " COMPARADO CON " + inmuebleForm.getTiposInmueble());
            if (tipo.toString().equalsIgnoreCase(inmuebleForm.getTiposInmueble())) {
                validarTiposInmueble = false;
            }
        }
        if (validarTiposInmueble) {
            throw new MiException("El tipo de inmueble no es válido");
        }
        boolean validarTipoNegocio = true;
        TipoNegocio[] validarTNegocio = TipoNegocio.getValues();
        for (TipoNegocio tipo : validarTNegocio) {
            if (tipo.toString().equalsIgnoreCase(inmuebleForm.getTipoNegocio())) {
                validarTipoNegocio = false;
            }
        }
        if (validarTipoNegocio) {
            throw new MiException("El tipo de inmueble no es válido");
        }
        if (inmuebleForm.getCaracteristicas() == null || inmuebleForm.getCaracteristicas().isEmpty()) {
            throw new MiException("No se ha procesado la direccion");
        }
    }

    public boolean isDireccionUnique(String direccion) {
        Inmueble existingInmueble = inmuebleRepositorio.findByDireccion(direccion);
        return existingInmueble != null;
    }

}
