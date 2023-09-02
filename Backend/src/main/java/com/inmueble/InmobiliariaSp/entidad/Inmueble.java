package com.inmueble.InmobiliariaSp.entidad;

import com.inmueble.InmobiliariaSp.enumeraciones.TipoNegocio;
import com.inmueble.InmobiliariaSp.enumeraciones.TiposInmueble;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Inmueble {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String direccion;
    private String caracteristicas;
    @ManyToOne
    private User dueño;
    @OneToOne
    private User inquilino;
    @Enumerated(EnumType.STRING)
    private TiposInmueble tiposInmueble;
    @Enumerated(EnumType.STRING)
    private TipoNegocio tipoNegocio;
    private int valor;

    public Inmueble() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public User getDueño() {
        return dueño;
    }

    public void setDueño(User dueño) {
        this.dueño = dueño;
    }

    public User getInquilino() {
        return inquilino;
    }

    public void setInquilino(User inquilino) {
        this.inquilino = inquilino;
    }

    public TiposInmueble getTiposInmueble() {
        return tiposInmueble;
    }

    public void setTiposInmueble(TiposInmueble tiposInmueble) {
        this.tiposInmueble = tiposInmueble;
    }

    public TipoNegocio getTipoNegocio() {
        return tipoNegocio;
<<<<<<< HEAD
    }

    public void setTipoNegocio(TipoNegocio tipoNegocio) {
        this.tipoNegocio = tipoNegocio;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Inmueble(String direccion, TiposInmueble tiposInmueble) {
        this.direccion = direccion;
        this.tiposInmueble = tiposInmueble;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

}
=======
    }

    public void setTipoNegocio(TipoNegocio tipoNegocio) {
        this.tipoNegocio = tipoNegocio;
    }

    public int getValorAlquiler() {
        return valorAlquiler;
    }

    public void setValorAlquiler(int valorAlquiler) {
        this.valorAlquiler = valorAlquiler;
    }

    public int getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(int valorVenta) {
        this.valorVenta = valorVenta;
    }

    public Inmueble(String direccion, TiposInmueble tiposInmueble) {
        this.direccion = direccion;
        this.tiposInmueble = tiposInmueble;
    }
    

}
>>>>>>> 514df8c79935f60ae60c73f34c347143a8b15513
