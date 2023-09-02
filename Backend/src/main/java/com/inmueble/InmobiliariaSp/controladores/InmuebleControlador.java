package com.inmueble.InmobiliariaSp.controladores;

import com.inmueble.InmobiliariaSp.config.JwtTokenProvider;
import com.inmueble.InmobiliariaSp.config.UserDetailsImpl;
import com.inmueble.InmobiliariaSp.contenedores.InmuebleForm;
import com.inmueble.InmobiliariaSp.entidad.Inmueble;
import com.inmueble.InmobiliariaSp.excepciones.MiException;
import com.inmueble.InmobiliariaSp.repositorios.InmuebleRepositorio;
import com.inmueble.InmobiliariaSp.servicios.InmuebleServicio;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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
@RequestMapping("api/inmueble/")
public class InmuebleControlador {

    @Autowired
    private InmuebleRepositorio inmuebleRepositorio;
    
    @Autowired
    private InmuebleServicio inmuebleServicio;
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("/inmuebles")
    public List<Inmueble> listarUsuarios() {
        return inmuebleRepositorio.findAll();
    }

<<<<<<< HEAD
    //Create Inmueble
=======
    @PreAuthorize("hasRole('ROLE_ENTE')")
>>>>>>> 514df8c79935f60ae60c73f34c347143a8b15513
    @PostMapping("/registroInmueble")
    public ResponseEntity<String> ingresarInmueble(@RequestBody InmuebleForm inmuebleForm, HttpServletRequest request) throws MiException {
        String token = jwtTokenProvider.resolveToken(request);

        if (token != null && jwtTokenProvider.validateToken(token)) {
            String userId = jwtTokenProvider.getUserIdFromJWT(token);
            String userRol = jwtTokenProvider.getRolesFromJWT(token).toString();  // Obtener los roles del token
            System.out.println("UserId:"+userId);
            System.out.println("UserRol:"+userRol);
            try {
                inmuebleServicio.crearInmuebleDesdeInmuebleForm(inmuebleForm, userId);
                return ResponseEntity.ok("Inmueble creado exitosamente");
            } catch (MiException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido");
        }
    }
    





    //Get Inmueble By Id
    @GetMapping("/{id}")
    public Inmueble getById(@PathVariable String id) {
        return inmuebleRepositorio.getReferenceById(id);
    }

    //Delete Inmueble
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInmueble(@PathVariable String id) {
        try {
            inmuebleRepositorio.deleteById(id);
            return new ResponseEntity<>("Inmueble eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el Inmueble", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
