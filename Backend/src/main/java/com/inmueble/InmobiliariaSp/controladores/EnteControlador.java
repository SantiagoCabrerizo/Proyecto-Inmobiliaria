
package com.inmueble.InmobiliariaSp.controladores;

import com.inmueble.InmobiliariaSp.entidad.Inmueble;
import com.inmueble.InmobiliariaSp.repositorios.InmuebleRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("api/ente/")
public class EnteControlador {
//
//    @Autowired
//    private InmuebleRepositorio inmuebleRepositorio;
//
//    //Read Users
//    @GetMapping("/misInmuebles")
//    public List<Inmueble> listarInmuebles(@PathVariable String enteId) {
//        return inmuebleRepositorio.findByDueño();
//    }

//    //Create Users
//    @PostMapping("/registro")
//    public Inmueble ingresarInmueble(@RequestBody Inmueble inmueble) {
//        return userRepositorio.save(user);
//    }
//
//    //Get User By Id
//    @GetMapping("/{id}")
//    public User getById(@PathVariable String id) {
//        return userRepositorio.getReferenceById(id);
//    }
//
//    //Delete Users
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable String id) {
//        try {
//            userRepositorio.deleteById(id);
//            return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error al eliminar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
