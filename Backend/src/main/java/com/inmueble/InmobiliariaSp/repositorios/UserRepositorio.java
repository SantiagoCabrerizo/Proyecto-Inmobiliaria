package com.inmueble.InmobiliariaSp.repositorios;

import com.inmueble.InmobiliariaSp.entidad.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepositorio extends JpaRepository<User,String>{
    
    
}