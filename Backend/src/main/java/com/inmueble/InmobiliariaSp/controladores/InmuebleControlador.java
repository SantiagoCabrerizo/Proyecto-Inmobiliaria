package com.inmueble.InmobiliariaSp.controladores;

import com.inmueble.InmobiliariaSp.config.UserDetailsImpl;
import com.inmueble.InmobiliariaSp.contenedores.InmuebleForm;
import com.inmueble.InmobiliariaSp.entidad.Inmueble;
import com.inmueble.InmobiliariaSp.excepciones.MiException;
import com.inmueble.InmobiliariaSp.repositorios.InmuebleRepositorio;
import com.inmueble.InmobiliariaSp.servicios.InmuebleServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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

    @GetMapping("/inmuebles")
    public List<Inmueble> listarUsuarios() {
        return inmuebleRepositorio.findAll();
    }

    //Create Users
    @PostMapping("/registroInmueble")
    @PreAuthorize("hasRole('ENTE')")
    public ResponseEntity<String> ingresarInmueble(@RequestBody InmuebleForm inmuebleForm, Authentication authentication) throws MiException {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            String userId = userDetails.getId();
            try {
            inmuebleServicio.crearInmuebleDesdeInmuebleForm(inmuebleForm, userId);
            return ResponseEntity.ok("Inmueble creado exitosamente");
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //Get User By Id
    @GetMapping("/{id}")
    public Inmueble getById(@PathVariable String id) {
        return inmuebleRepositorio.getReferenceById(id);
    }

    //Delete Users
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
