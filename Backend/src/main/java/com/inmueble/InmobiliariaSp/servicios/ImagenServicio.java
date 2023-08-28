/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inmueble.InmobiliariaSp.servicios;

import com.inmueble.InmobiliariaSp.entidad.Imagen;
import com.inmueble.InmobiliariaSp.entidad.Inmueble;
import com.inmueble.InmobiliariaSp.excepciones.MiException;
import com.inmueble.InmobiliariaSp.repositorios.ImagenRepositorio;
import com.inmueble.InmobiliariaSp.repositorios.InmuebleRepositorio;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenServicio {
    
    @Autowired
    private InmuebleRepositorio inmuebleRepositorio;
    @Autowired
    private ImagenRepositorio imagenRepositorio;
    
    
    public void guardar(MultipartFile archivo, String inmuebleId) throws MiException {
        if (inmuebleId != null) {
            Optional<Inmueble> respuestaInmueble = inmuebleRepositorio.findById(inmuebleId);
            if (respuestaInmueble.isPresent()) {
                if (archivo != null) {
                    try {
                        Imagen imagen = new Imagen();
                        imagen.setMime(archivo.getContentType());
                        imagen.setNombre(archivo.getName());
                        imagen.setContenido(archivo.getBytes());
                        imagen.setInmueble(respuestaInmueble.get());
                        imagenRepositorio.save(imagen);
                    } catch (Exception e) {
                        throw new MiException("Archivo invalido" + e);
                    }
                } else {
                    throw new MiException("El archivo no puede ser nulo");
                }
            } else {
                throw new MiException("El id de inmueble es incorrecto");
            }
        } else {
            throw new MiException("El id de inmueble no puede ser nulo");
        }
    }
    
    public void actualizar(MultipartFile archivo, String imagenId) throws MiException{
        if (imagenId != null) {
            Optional<Imagen> respuestaImagen = imagenRepositorio.findById(imagenId);
            if (respuestaImagen.isPresent()) {
                if (archivo != null) {
                    try {
                        Imagen imagen = respuestaImagen.get();
                        imagen.setMime(archivo.getContentType());
                        imagen.setNombre(archivo.getName());
                        imagen.setContenido(archivo.getBytes());
                        imagenRepositorio.save(imagen);
                    } catch (Exception e) {
                        throw new MiException("Archivo invalido" + e);
                    }
                } else {
                    throw new MiException("El archivo no puede ser nulo");
                }
            } else {
                throw new MiException("El id de imagen es incorrecto");
            }
        } else {
            throw new MiException("El id de imagen no puede ser nulo");
        }
    }
    
}
