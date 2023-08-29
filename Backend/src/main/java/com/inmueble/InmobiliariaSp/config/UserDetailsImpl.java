/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inmueble.InmobiliariaSp.config;

import com.inmueble.InmobiliariaSp.entidad.User;
import com.inmueble.InmobiliariaSp.enumeraciones.Rol;
import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserDetailsImpl implements UserDetails {

    private String id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String id, String username, String password, Rol rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_" + rol.name()));
    }
    
    private Collection<? extends GrantedAuthority> buildAuthorities(Rol rol) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.name()));

        // Si el usuario tiene el rol CLIENTYENTE, se agrega también ENTE y CLIENTE
        if (rol.equals(Rol.CLIENTYENTE)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
            authorities.add(new SimpleGrantedAuthority("ROLE_ENTE"));
        }

        return authorities;
    }

    public static UserDetailsImpl build(User user) {
        return new UserDetailsImpl(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getRol()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
    
    public String getId() {
        return id;
    }

    @Override
public boolean isAccountNonExpired() {
    return true; // Las cuentas nunca expiran
}

@Override
public boolean isAccountNonLocked() {
    return true; // Las cuentas nunca están bloqueadas
}

@Override
public boolean isCredentialsNonExpired() {
    return true; // Las credenciales nunca expiran
}

@Override
public boolean isEnabled() {
    return true; // Las cuentas siempre están habilitadas
}
}