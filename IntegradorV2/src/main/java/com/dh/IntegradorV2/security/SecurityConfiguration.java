package com.dh.IntegradorV2.security;

import com.dh.IntegradorV2.model.UsuarioRol;
import com.dh.IntegradorV2.service.UsuarioServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioServiceRepository usuarioServiceRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/turnos").permitAll()
                .antMatchers("/pacientes").hasRole(UsuarioRol.ADMIN.name())
                .antMatchers("/odontologo").hasRole(UsuarioRol.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .formLogin();

        //Agrego esta ultima linea para habilitar la visualizacion de la consola h2 mediante el localhost
        http.headers().frameOptions().disable();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(usuarioServiceRepository);
        provider.setPasswordEncoder(encoder);
        return provider;
    }
}
