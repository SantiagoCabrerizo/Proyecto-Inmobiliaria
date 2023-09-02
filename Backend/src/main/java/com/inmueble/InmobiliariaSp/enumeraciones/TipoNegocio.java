package com.inmueble.InmobiliariaSp.enumeraciones;

public enum TipoNegocio {
    VENTA,
    ALQUILER,
    ALQUILEROVENTA;

    public static TipoNegocio[] getValues() {
        return TipoNegocio.values();
    }
}
