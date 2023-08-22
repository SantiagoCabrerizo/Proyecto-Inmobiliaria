package com.inmueble.InmobiliariaSp.repositorios;

import com.inmueble.InmobiliariaSp.entidad.Transacciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionesRepositorio extends JpaRepository<Transacciones, Long> {

}
