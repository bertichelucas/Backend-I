package com.dh.IntegradorV2.service;

import com.dh.IntegradorV2.model.Usuario;
import com.dh.IntegradorV2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceRepository implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioBuscado = usuarioRepository.findByEmail(username);
        if (usuarioBuscado.isPresent()){
            return usuarioBuscado.get();
        }
        throw  new UsernameNotFoundException("Email no encontrado en la base de datos");
    }
}
