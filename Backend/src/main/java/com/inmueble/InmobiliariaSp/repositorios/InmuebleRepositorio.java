package com.inmueble.InmobiliariaSp.repositorios;

import com.inmueble.InmobiliariaSp.entidad.Inmueble;
import com.inmueble.InmobiliariaSp.entidad.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InmuebleRepositorio extends JpaRepository<Inmueble, String> {

    Inmueble findByDireccion(String direccion);
<<<<<<< HEAD

=======
>>>>>>> 514df8c79935f60ae60c73f34c347143a8b15513
    List<Inmueble> findByDueño(User dueño);
}
