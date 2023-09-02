package com.inmueble.InmobiliariaSp.servicios;

import com.inmueble.InmobiliariaSp.config.UserDetailsImpl;
import com.inmueble.InmobiliariaSp.contenedores.UserForm;
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
    public void crearUsuarioDesdeUserForm(UserForm userForm) throws MiException {
        validar(userForm);
        User user = new User();
        user.setApellido(userForm.getApellido());
        user.setDni(userForm.getDni());
        user.setEmail(userForm.getEmail());
        user.setNombre(userForm.getNombre());
        Rol[] validar = Rol.getValues();
        for (Rol tipo : validar) {
            if (tipo.toString().equalsIgnoreCase(userForm.getRol())) {
                user.setRol(tipo);
            }
        }
        String password = userForm.getPassword();
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        userRepositorio.save(user);
    }

<<<<<<< HEAD
    public void validar(UserForm userForm) throws MiException {
        if (isEmailUnique(userForm.getEmail())) {
            throw new MiException("El email ingresado ya se encuentra registrado.");
        }
        if (isDniUnique(userForm.getDni())) {
=======
    
    public void validar(UserForm userForm) throws MiException {
        if (isEmailUnique(userForm.getEmail())){
            throw new MiException("El email ingresado ya se encuentra registrado.");
        }
        if (isDniUnique(userForm.getDni())){
>>>>>>> 514df8c79935f60ae60c73f34c347143a8b15513
            throw new MiException("El dni ingresado ya se encuentra registrado.");
        }
        if (userForm.getNombre() == null || userForm.getNombre().isEmpty()) {
            throw new MiException("No se ha procesado el nombre");
        }
<<<<<<< HEAD
        if (userForm.getApellido() == null || userForm.getApellido().isEmpty()) {
=======
        if (userForm.getApellido()== null || userForm.getApellido().isEmpty()) {
>>>>>>> 514df8c79935f60ae60c73f34c347143a8b15513
            throw new MiException("No se ha procesado el apellido");
        }
        if (userForm.getEmail() == null || userForm.getEmail().isEmpty()) {
            throw new MiException("El email no existe o es nullo");
        }
<<<<<<< HEAD
        if (userForm.getPassword() == null || userForm.getPassword().isEmpty()) {
=======
        if (userForm.getPassword()== null || userForm.getPassword().isEmpty()) {
>>>>>>> 514df8c79935f60ae60c73f34c347143a8b15513
            throw new MiException("La contrasena es incorrecta");
        }
        if (userForm.getDni() == null || userForm.getDni().isEmpty()) {
            throw new MiException("DNI incorrecto");
        }
        boolean validarRol = true;
        Rol[] validar = Rol.getValues();
        for (Rol tipo : validar) {
            if (tipo.toString().equalsIgnoreCase(userForm.getRol())) {
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
        Optional<User> respuestaUserId = userRepositorio.findById(username);
        User user;
        if(respuestaUserDni != null){
            user = respuestaUserDni;
        } else {
            if(respuestaUserEmail != null){
                user = respuestaUserEmail;
            } else {
                if(respuestaUserId.isPresent()){
                    user = respuestaUserId.get();
                } else {
                throw new UsernameNotFoundException("Usuario no encontrado: " + username);
                }
            }
        }

<<<<<<< HEAD
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User respuestaUserDni = userRepositorio.findByDni(username);
        User respuestaUserEmail = userRepositorio.findByEmail(username);
        Optional<User> respuestaUserId = userRepositorio.findById(username);
        User user;
        if (respuestaUserDni != null) {
            user = respuestaUserDni;
        } else {
            if (respuestaUserEmail != null) {
                user = respuestaUserEmail;
            } else {
                if (respuestaUserId.isPresent()) {
                    user = respuestaUserId.get();
                } else {
                    throw new UsernameNotFoundException("Usuario no encontrado: " + username);
                }
            }
        }

=======
>>>>>>> 514df8c79935f60ae60c73f34c347143a8b15513
        return UserDetailsImpl.build(user);
    }
}
