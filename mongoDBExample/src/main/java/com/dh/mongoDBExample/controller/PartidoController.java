package com.dh.mongoDBExample.controller;

import com.dh.mongoDBExample.entity.Partido;
import com.dh.mongoDBExample.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    private PartidoService partidoService;

    @Autowired
    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @PostMapping
    public ResponseEntity<Partido> agregarPartido(@RequestBody Partido partido){
        return ResponseEntity.ok(this.partidoService.agregarPartido(partido));
    }
}
