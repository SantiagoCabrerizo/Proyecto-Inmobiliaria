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
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserDetailsImpl implements UserDetails {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsImpl.class);
    private String id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        Collection<? extends GrantedAuthority> authorities = buildAuthorities(user.getRol());
        return new UserDetailsImpl(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    private static Collection<? extends GrantedAuthority> buildAuthorities(Rol rol) {
        logger.debug("Building authorities for role: " + rol.name());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.name()));

        // Si el usuario tiene el rol CLIENTYENTE, se agrega también ENTE y CLIENTE
        if (rol.equals(Rol.CLIENTYENTE)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
            authorities.add(new SimpleGrantedAuthority("ROLE_ENTE"));
        }

        return authorities;
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
