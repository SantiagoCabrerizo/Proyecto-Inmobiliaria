
package com.inmueble.InmobiliariaSp.controladores;



import com.inmueble.InmobiliariaSp.repositorios.InmuebleRepositorio;
import com.inmueble.InmobiliariaSp.servicios.InmuebleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("api/ente/")
public class EnteControlador {

    @Autowired
    private InmuebleRepositorio inmuebleRepositorio;
    
    @Autowired
    private InmuebleServicio inmuebleServicio;

//    //Read Users
//    @GetMapping("/misInmuebles")
//    public List<Inmueble> listarInmuebles(@PathVariable String enteId) {
//        return inmuebleRepositorio.findByDueño();
//    }

//    @PostMapping("/inmueble/alta")
//    public ResponseEntity<String> crearInmueble(InmuebleForm inmuebleForm) throws MiException {
//        try {
//            inmuebleServicio.crearInmueble(inmueble, idUser);
//            return ResponseEntity.ok("Usuario creado exitosamente");
//        } catch (MiException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
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
