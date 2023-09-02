package com.inmueble.InmobiliariaSp.repositorios;

import com.inmueble.InmobiliariaSp.entidad.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepositorio extends JpaRepository<Imagen, String> {

}
