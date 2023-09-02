/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inmueble.InmobiliariaSp.enumeraciones;

/**
 *
 * @author 4rm4c
 */
public enum TipoTransaccion {
    COMPROBANTEPAGO,
    RECIBO,
    IMPUESTO;
public static TipoTransaccion[] getValues() {
        return TipoTransaccion.values();
    }
}

