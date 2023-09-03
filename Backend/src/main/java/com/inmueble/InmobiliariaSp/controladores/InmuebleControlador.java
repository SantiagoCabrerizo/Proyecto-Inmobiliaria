package com.inmueble.InmobiliariaSp.controladores;

import com.inmueble.InmobiliariaSp.config.JwtTokenProvider;
import com.inmueble.InmobiliariaSp.config.UserDetailsImpl;
import com.inmueble.InmobiliariaSp.contenedores.InmuebleForm;
import com.inmueble.InmobiliariaSp.entidad.Inmueble;
import com.inmueble.InmobiliariaSp.excepciones.MiException;
import com.inmueble.InmobiliariaSp.repositorios.InmuebleRepositorio;
import com.inmueble.InmobiliariaSp.servicios.ImagenServicio;
import com.inmueble.InmobiliariaSp.servicios.InmuebleServicio;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("api/inmueble/")
public class InmuebleControlador {

    @Autowired
    private InmuebleRepositorio inmuebleRepositorio;
    
    @Autowired
    private InmuebleServicio inmuebleServicio;
    
    @Autowired
    private ImagenServicio imagenServicio;
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("/inmuebles")
    public List<Inmueble> listarUsuarios() {
        return inmuebleRepositorio.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ENTE')")
    @PostMapping("/registroInmueble")
    public ResponseEntity<String> ingresarInmueble(@ModelAttribute InmuebleForm inmuebleForm,
                                               @RequestParam("foto") MultipartFile foto,
                                               HttpServletRequest request) throws MiException {
        String token = jwtTokenProvider.resolveToken(request);

        if (token != null && jwtTokenProvider.validateToken(token)) {
            String userId = jwtTokenProvider.getUserIdFromJWT(token);
            String userRol = jwtTokenProvider.getRolesFromJWT(token).toString();  // Obtener los roles del token
            System.out.println("UserId:"+userId);
            System.out.println("UserRol:"+userRol);
            try {
                Inmueble inmueble = inmuebleServicio.crearInmuebleDesdeInmuebleForm(inmuebleForm, userId);
                imagenServicio.guardar(foto, inmueble.getId());
                return ResponseEntity.ok("Inmueble creado exitosamente");
            } catch (MiException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido");
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
    
    @GetMapping("/listar")
    public Page<Object[]> getInmueblesWithOffset(@RequestParam int offset) {
        return inmuebleServicio.getInmueblesDisponiblesWithOffset(offset);
    }

}
