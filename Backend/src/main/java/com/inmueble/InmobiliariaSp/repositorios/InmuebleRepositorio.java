package com.inmueble.InmobiliariaSp.repositorios;


import com.inmueble.InmobiliariaSp.entidad.Inmueble;
import com.inmueble.InmobiliariaSp.entidad.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InmuebleRepositorio extends JpaRepository<Inmueble, String> {

    Inmueble findByDireccion(String direccion);

    List<Inmueble> findByDueño(User dueño);
    List<Inmueble> findByInquilino(User inquilino);

    @Query("SELECT i, MAX(im.contenido) AS primeraImagenContenido "
            + "FROM Inmueble i "
            + "LEFT JOIN Imagen im ON i.id = im.inmueble.id "
            + "WHERE i.inquilino IS NULL "
            + "GROUP BY i.id")
    Page<Object[]> getInmueblesDisponiblesWithOffset(Pageable pageable);
    
    @Query("SELECT i, MAX(im.contenido) AS primeraImagenContenido "
        + "FROM Inmueble i "
        + "LEFT JOIN Imagen im ON i.id = im.inmueble.id "
        + "WHERE i.id = :inmuebleId " // Agregar las condiciones de filtro
        + "GROUP BY i.id")
    List<Object[]> getInmuebleByIdConImagen(@Param("inmuebleId") String inmuebleId);
    
    @Query("SELECT i, MAX(im.contenido) AS primeraImagenContenido "
        + "FROM Inmueble i "
        + "LEFT JOIN Imagen im ON i.id = im.inmueble.id "
        + "WHERE i.inquilino IS NULL AND i.dueño != :parametroDueño " // Agregar las condiciones de filtro
        + "GROUP BY i.id")
    Page<Object[]> getInmueblesDisponiblesWithOffsetSinDueño(@Param("parametroDueño") User parametroDueño, Pageable pageable);
}
