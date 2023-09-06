package com.inmueble.InmobiliariaSp.controladores;

import com.inmueble.InmobiliariaSp.config.JwtTokenProvider;
import com.inmueble.InmobiliariaSp.contenedores.UserForm;
import com.inmueble.InmobiliariaSp.entidad.User;
import com.inmueble.InmobiliariaSp.excepciones.MiException;
import com.inmueble.InmobiliariaSp.repositorios.UserRepositorio;
import com.inmueble.InmobiliariaSp.servicios.UserServicio;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/")
@CrossOrigin(origins = "http://localhost:5173")
public class UserControlador {

    @Autowired
    private UserRepositorio userRepositorio;
    @Autowired
    private UserServicio userServicio;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    //Read Users
    @GetMapping("/usuarios")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> listarUsuarios() {
        return userRepositorio.findAll();
    }

    //Create Users
    @PostMapping("/registro")
    public ResponseEntity<String> crearUsuario(@RequestBody UserForm userForm) throws MiException {
        try {
            userServicio.crearUsuarioDesdeUserForm(userForm);
            return ResponseEntity.ok("Usuario creado exitosamente");
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //Get User By Id
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('ENTE') or hasRole('CLIENT')")
    public ResponseEntity<UserForm> getById(@PathVariable String id) {
        User usuario = userRepositorio.getReferenceById(id);
        UserForm userForm = new UserForm();
        userForm.setId(usuario.getId());
        userForm.setNombre(usuario.getNombre());
        userForm.setApellido(usuario.getApellido());
        userForm.setEmail(usuario.getEmail());
        userForm.setDni(usuario.getDni());

        
        return ResponseEntity.ok(userForm);
    }

    //Delete Users
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable String id) throws MiException {
        try {
            userServicio.deleteById(id);
            return new ResponseEntity<>("Usuario eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('CLIENT') or hasRole('ENTE') ")
    public ResponseEntity<String> modificarUser (@RequestBody UserForm userForm, HttpServletRequest request) throws MiException{
        String token = jwtTokenProvider.resolveToken(request);
        String userId = null;
        if (token != null && jwtTokenProvider.validateToken(token)) {
            userId = jwtTokenProvider.getUserIdFromJWT(token);
            String userRol = jwtTokenProvider.getRolesFromJWT(token).toString();  // Obtener los roles del token
            System.out.println("UserId:"+userId);
            System.out.println("UserRol:"+userRol);
        }
        try {
            userServicio.modificarUserComoClient(userForm, userId);
            return new ResponseEntity<>("Usuario modificado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al modificar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
