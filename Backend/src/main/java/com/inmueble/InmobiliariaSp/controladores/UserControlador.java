package com.inmueble.InmobiliariaSp.controladores;

import com.inmueble.InmobiliariaSp.entidad.User;
import com.inmueble.InmobiliariaSp.excepciones.MiException;
import com.inmueble.InmobiliariaSp.repositorios.UserRepositorio;
import com.inmueble.InmobiliariaSp.servicios.UserServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("api/user/")
public class UserControlador {
    
    @Autowired
    private UserRepositorio userRepositorio;
    @Autowired
    private UserServicio userServicio;

    //Read Users
    @GetMapping("/usuarios")
    public List<User> listarUsuarios() {
        return userRepositorio.findAll();
    }

    //Create Users
    @PostMapping("/registro")
    public ResponseEntity<String> crearUsuario(@RequestBody User user) throws MiException {
        try {
            userServicio.crearUsuario(user);
            return ResponseEntity.ok("Usuario creado exitosamente");
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //Get User By Id
    @GetMapping("/{id}")
    public User getById(@PathVariable String id) {
        return userRepositorio.getReferenceById(id);
    }

    //Delete Users
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        try {
            userRepositorio.deleteById(id);
            return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
