package com.inmueble.InmobiliariaSp.enumeraciones;

public enum TiposInmueble {
    CASA,
    DEPARTAMENTO,
    OFICINA;

    public static TiposInmueble[] getValues() {
        return TiposInmueble.values();
    }
}
