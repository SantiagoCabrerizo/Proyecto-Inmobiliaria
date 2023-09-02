package com.inmueble.InmobiliariaSp.enumeraciones;

public enum Rol {
    CLIENT,
    ENTE,
    CLIENTYENTE,
    ADMIN;

    public static Rol[] getValues() {
        return Rol.values();
    }
}
