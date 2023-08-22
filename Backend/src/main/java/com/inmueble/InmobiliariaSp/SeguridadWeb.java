///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.inmueble.InmobiliariaSp;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//
///**
// *
// * @author oscarloha
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SeguridadWeb extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public UsuarioServicio usuarioServicio;
//
//    //crea funcion de codificacion
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(usuarioServicio)
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//    // Ingresa las autorizaciones de 1r ingreso
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/administrador/*").hasRole("ADMIN")
//                .antMatchers("/css/*", "/js/*", "/img/*", "/**") // Se permite el acceso público a los recursos estáticos y a todas las demás URL
//                .permitAll()
//                // Si se ingresa a través de:...
//                .and().formLogin()
//                .loginPage("/login") // Se especifica la URL de la página de inicio de sesión
//                .loginProcessingUrl("/logincheck") // Se especifica la URL de procesamiento de inicio de sesión
//                .usernameParameter("email") // Se especifica el nombre del parámetro del correo electrónico en el formulario de inicio de sesión
//                .passwordParameter("password") // Se especifica el nombre del parámetro de la contraseña en el formulario de inicio de sesión
//                .defaultSuccessUrl("/") // Se especifica la URL a la que se redirigirá después de un inicio de sesión exitoso
//                .permitAll() // Se permite el acceso público a las páginas de inicio de sesión y éxito
//                // Para salir de sesion:...
//                .and().logout()
//                .logoutUrl("/logout") // Se especifica la URL de cierre de sesión
//                .logoutSuccessUrl("/inicio") // Se especifica la URL a la que se redirigirá después de un cierre de sesión exitoso
//                .permitAll() // Se permite el acceso público a la página de cierre de sesión
//                .and().csrf()
//                .disable();
//        
//    }
//
//}
