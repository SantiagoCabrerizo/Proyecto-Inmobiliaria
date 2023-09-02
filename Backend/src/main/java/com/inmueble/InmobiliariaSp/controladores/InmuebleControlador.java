package com.inmueble.InmobiliariaSp.controladores;

import com.inmueble.InmobiliariaSp.entidad.Inmueble;
import com.inmueble.InmobiliariaSp.repositorios.InmuebleRepositorio;
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
@RequestMapping("api/inmueble/")
public class InmuebleControlador {

    @Autowired
    private InmuebleRepositorio inmuebleRepositorio;

    @GetMapping("/inmuebles")
    public List<Inmueble> listarUsuarios() {
        return inmuebleRepositorio.findAll();
    }

    //Create Inmueble
    @PostMapping("/registroInmueble")
    public Inmueble ingresarInmueble(@RequestBody Inmueble inmueble) {
        return inmuebleRepositorio.save(inmueble);
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
