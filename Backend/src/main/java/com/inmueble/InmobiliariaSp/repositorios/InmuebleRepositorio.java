package com.inmueble.InmobiliariaSp.repositorios;


import com.inmueble.InmobiliariaSp.entidad.Inmueble;
import com.inmueble.InmobiliariaSp.enumeraciones.TiposInmueble;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InmuebleRepositorio extends JpaRepository<Inmueble, String> {


}
