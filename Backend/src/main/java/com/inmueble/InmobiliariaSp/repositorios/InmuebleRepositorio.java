package com.inmueble.InmobiliariaSp.repositorios;


import com.inmueble.InmobiliariaSp.entidad.Inmueble;
import com.inmueble.InmobiliariaSp.entidad.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InmuebleRepositorio extends JpaRepository<Inmueble, String> {

    Inmueble findByDireccion(String direccion);

    List<Inmueble> findByDueño(User dueño);

    @Query("SELECT i, MAX(im.contenido) AS primeraImagenContenido "
            + "FROM Inmueble i "
            + "LEFT JOIN Imagen im ON i.id = im.inmueble.id "
            + "GROUP BY i.id")
    Page<Object[]> getInmueblesWithOffset(Pageable pageable);
}
