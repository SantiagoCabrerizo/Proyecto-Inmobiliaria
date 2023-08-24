package com.inmueble.InmobiliariaSp.servicios;

import com.inmueble.InmobiliariaSp.entidad.User;
import com.inmueble.InmobiliariaSp.enumeraciones.Rol;
import com.inmueble.InmobiliariaSp.excepciones.MiException;
import com.inmueble.InmobiliariaSp.repositorios.UserRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//implements UserDetailsService
public class UserServicio {

    @Autowired
    private UserRepositorio userRepositorio;
    
    @Transactional
    public void crearUsuario(User user) throws MiException {
        validar(user);
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
            throw new MiException("No se a procesado el nombre");
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
    //metodo listar usuarios
    public List<User> listarUsuarios() {
        return userRepositorio.findAll();
    }
    
    public boolean isEmailUnique(String email) {
        User existingUser = userRepositorio.findByEmail(email);
        return existingUser == null;
    }

    public boolean isDniUnique(String dni) {
        User existingUser = userRepositorio.findByDni(dni);
        return existingUser == null;
    }

//     //configuracion pre-creada que me permite darle el permiso deseado a un usuario
//    @Override
//    // el email sera el "nombre" con el que reprecento el usuario
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User usuario = usuarioRepositorio.buscarPorEmail(email);
//        
//        if(usuario != null){
//            
//            List <GrantedAuthority> permisos = new ArrayList();
//            
//            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString()); //ROLE_USER
//            
//            permisos.add(p);
//            
//            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//            
//            HttpSession session = attr.getRequest().getSession(true);
//             
//            session.setAttribute("usuariosession", usuario);
//            
//            return new User(usuario.getEmail(),usuario.getPassword(),permisos);
//        }else{
//            return null;
//        }
//    }
}
