package com.inmueble.InmobiliariaSp.enumeraciones;

public enum TipoTransaccion {
    COMPROBANTEPAGO,
    RECIBO,
    IMPUESTO;

    public static TipoTransaccion[] getValues() {
        return TipoTransaccion.values();
    }
}
