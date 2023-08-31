/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inmueble.InmobiliariaSp.contenedores;



/**
 *
 * @author 4rm4c
 */
public class InmuebleForm {

    private String direccion;
    private String tiposInmueble;
    private String tipoNegocio;
    private String valorAlquiler;
    private String valorVenta;

    public InmuebleForm(String direccion, String tiposInmueble, String tipoNegocio, String valorAlquiler, String valorVenta) {
        this.direccion = direccion;
        this.tiposInmueble = tiposInmueble;
        this.tipoNegocio = tipoNegocio;
        this.valorAlquiler = valorAlquiler;
        this.valorVenta = valorVenta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTiposInmueble() {
        return tiposInmueble;
    }

    public void setTiposInmueble(String tiposInmueble) {
        this.tiposInmueble = tiposInmueble;
    }

    public String getTipoNegocio() {
        return tipoNegocio;
    }

    public void setTipoNegocio(String tipoNegocio) {
        this.tipoNegocio = tipoNegocio;
    }

    public String getValorAlquiler() {
        return valorAlquiler;
    }

    public void setValorAlquiler(String valorAlquiler) {
        this.valorAlquiler = valorAlquiler;
    }

    public String getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(String valorVenta) {
        this.valorVenta = valorVenta;
    }
    
    
}
