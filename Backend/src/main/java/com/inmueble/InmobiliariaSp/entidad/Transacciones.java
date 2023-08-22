package com.inmueble.InmobiliariaSp.entidad;

import com.inmueble.InmobiliariaSp.enumeraciones.TipoTransaccion;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




@Entity
public class Transacciones {

@Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
@ManyToOne
    private Inmueble inmueble;

    private String nombre;
    
        @Enumerated(EnumType.STRING)
    private TipoTransaccion tipoTransaccion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Transacciones(Long id, Inmueble inmueble, String nombre, TipoTransaccion tipoTransaccion) {
        this.id = id;
        this.inmueble = inmueble;
        this.nombre = nombre;
        this.tipoTransaccion = tipoTransaccion;
    }

    public Transacciones() {
    }
}
