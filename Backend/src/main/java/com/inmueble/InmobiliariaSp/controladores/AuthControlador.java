
package com.inmueble.InmobiliariaSp.controladores;

import com.inmueble.InmobiliariaSp.config.JwtTokenProvider;
import com.inmueble.InmobiliariaSp.contenedores.JwtResponse;
import com.inmueble.InmobiliariaSp.contenedores.LoginForm;
import com.inmueble.InmobiliariaSp.servicios.UserServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthControlador {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserServicio userServicio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginForm) {
        UserDetails userDetails = userServicio.loadUserByUsername(loginForm.getUsername());

        if (passwordEncoder.matches(loginForm.getPassword(), userDetails.getPassword())) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtTokenProvider.generateToken(authentication);
            return ResponseEntity.ok(new JwtResponse(token));
        } else {
            // La contraseña no coincide, devolver una respuesta de error
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
