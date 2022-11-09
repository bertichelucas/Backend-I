package com.example.springmvc.controller;

import com.example.springmvc.model.Usuario;
import com.example.springmvc.services.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    private static final UsuarioService usuarioService = new UsuarioService();

    @GetMapping("/")
    public Usuario crearUsuario(){
        return usuarioService.crearUsuario();
    }
}
