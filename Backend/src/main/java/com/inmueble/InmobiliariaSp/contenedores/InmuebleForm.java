/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inmueble.InmobiliariaSp.contenedores;

import org.springframework.web.multipart.MultipartFile;



/**
 *
 * @author 4rm4c
 */
public class InmuebleForm {

    private String direccion;
    private String caracteristicas;
    private String tiposInmueble;
    private String tipoNegocio;
    private String valor;
    private MultipartFile foto;

    public InmuebleForm(String direccion, String caracteristicas, String tiposInmueble, String tipoNegocio, String valor, MultipartFile foto) {
        this.direccion = direccion;
        this.caracteristicas = caracteristicas;
        this.tiposInmueble = tiposInmueble;
        this.tipoNegocio = tipoNegocio;
        this.valor = valor;
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public MultipartFile getFoto() {
        return foto;
    }

    public void setFoto(MultipartFile foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InmuebleForm{");
        sb.append("direccion=").append(direccion);
        sb.append(", caracteristicas=").append(caracteristicas);
        sb.append(", tiposInmueble=").append(tiposInmueble);
        sb.append(", tipoNegocio=").append(tipoNegocio);
        sb.append(", valor=").append(valor);
        sb.append(", foto=").append(foto);
        sb.append('}');
        return sb.toString();
    }

    
}