package com.inmueble.InmobiliariaSp.controladores;

import com.inmueble.InmobiliariaSp.entidad.User;
import com.inmueble.InmobiliariaSp.excepciones.MiException;
import com.inmueble.InmobiliariaSp.repositorios.UserRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5174/")
@RestController
@RequestMapping("api/")
public class PortalControlador {
    
//    @Autowired
//    private UserServicios userServicios;
//    @Autowired
//    private UserRepositorio userRepositorio;
//    
//    //Listar usuarios
//    @GetMapping("/usuarios")
//    public List<User> listarUsuarios() {
//        return userRepositorio.findAll();
//    }
//    
//    
}
