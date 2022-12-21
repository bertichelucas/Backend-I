package com.dh.IntegradorV2.security;

import com.dh.IntegradorV2.model.Usuario;
import com.dh.IntegradorV2.model.UsuarioRol;
import com.dh.IntegradorV2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CargarDatosIniciales implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public CargarDatosIniciales(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //cargo un usuario para probar
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passCifrada = encoder.encode("peronperon11");
        Usuario usuario = new Usuario("Lucas", "Luquitas", "bertichelucasUser@gmail.com",
                passCifrada, UsuarioRol.USER);
        usuarioRepository.save(usuario);
        Usuario usuario2 = new Usuario("Lucas", "Luquitas", "bertichelucasAdmin@gmail.com",
                passCifrada, UsuarioRol.ADMIN);
        usuarioRepository.save(usuario2);
    }
}
