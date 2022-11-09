package com.example.springmvc.services;

import com.example.springmvc.model.Usuario;

public class UsuarioService {

    public Usuario crearUsuario(){
        Usuario user = new Usuario("Diego", 24);
        return user;
    }
}
