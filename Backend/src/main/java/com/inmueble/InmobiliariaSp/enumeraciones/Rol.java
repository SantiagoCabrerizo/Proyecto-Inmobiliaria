/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inmueble.InmobiliariaSp.enumeraciones;

/**
 *
 * @author oscarloha
 */
public enum Rol {
    CLIENT,
    ENTE,
    CLIENTYENTE,
    ADMIN;
public static Rol[] getValues() {
        return Rol.values();
    }
}