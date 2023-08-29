package com.inmueble.InmobiliariaSp.servicios;

import com.inmueble.InmobiliariaSp.config.UserDetailsImpl;
import com.inmueble.InmobiliariaSp.entidad.User;
import com.inmueble.InmobiliariaSp.enumeraciones.Rol;
import com.inmueble.InmobiliariaSp.excepciones.MiException;
import com.inmueble.InmobiliariaSp.repositorios.UserRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServicio implements UserDetailsService {

    @Autowired
    private UserRepositorio userRepositorio;
    
    @Transactional
    public void crearUsuario(User user) throws MiException {
        validar(user);
        String password = user.getPassword();
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        userRepositorio.save(user);
    }

    
    public void validar(User user) throws MiException {
        if (isEmailUnique(user.getEmail())){
            throw new MiException("El email ingresado ya se encuentra registrado.");
        }
        if (isDniUnique(user.getDni())){
            throw new MiException("El dni ingresado ya se encuentra registrado.");
        }
        if (user.getNombre() == null || user.getNombre().isEmpty()) {
            throw new MiException("No se ha procesado el nombre");
        }
        if (user.getApellido()== null || user.getApellido().isEmpty()) {
            throw new MiException("No se ha procesado el apellido");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new MiException("El email no existe o es nullo");
        }
        if (user.getPassword()== null || user.getPassword().isEmpty()) {
            throw new MiException("La contrasena es incorrecta");
        }
        if (user.getDni() == null || user.getDni().isEmpty()) {
            throw new MiException("DNI incorrecto");
        }
        boolean validarRol = true;
        Rol[] validar = Rol.getValues();
        for (Rol tipo : validar) {
            if (tipo.equals(user.getRol())) {
                validarRol = false;
            }
        }
        if (validarRol) {
            throw new MiException("Rol no es válido");
        }
    }
    
    public List<User> listarUsuarios() {
        return userRepositorio.findAll();
    }
    
    public boolean isEmailUnique(String email) {
        User existingUser = userRepositorio.findByEmail(email);
        return existingUser != null;
    }

    public boolean isDniUnique(String dni) {
        User existingUser = userRepositorio.findByDni(dni);
        return existingUser != null;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User respuestaUserDni = userRepositorio.findByDni(username);
        User respuestaUserEmail = userRepositorio.findByEmail(username);
        User user;
        if(respuestaUserDni != null){
            user = respuestaUserDni;
        } else {
            if(respuestaUserEmail != null){
                user = respuestaUserEmail;
            } else {
                throw new UsernameNotFoundException("Usuario no encontrado: " + username);
            }
        }

        return UserDetailsImpl.build(user);
    }
}
