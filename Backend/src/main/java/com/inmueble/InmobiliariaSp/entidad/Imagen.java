<<<<<<< HEAD
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
>>>>>>> 514df8c79935f60ae60c73f34c347143a8b15513
package com.inmueble.InmobiliariaSp.entidad;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

<<<<<<< HEAD
@Entity
public class Imagen {

=======
/**
 *
 * @author 4rm4c
 */
@Entity
public class Imagen {
>>>>>>> 514df8c79935f60ae60c73f34c347143a8b15513
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
<<<<<<< HEAD

    private String mime;

    private String nombre;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] contenido;

    @ManyToOne
    private Inmueble inmueble;

    public Imagen() {
    }

=======
    
    private String mime;
    
    private String nombre;
    
    @Lob @Basic(fetch = FetchType.LAZY)
    private byte[] contenido;
    
    @ManyToOne
    private Inmueble inmueble;
    
    public Imagen() {
    }
    
>>>>>>> 514df8c79935f60ae60c73f34c347143a8b15513
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }
<<<<<<< HEAD

=======
        
    
>>>>>>> 514df8c79935f60ae60c73f34c347143a8b15513
}
