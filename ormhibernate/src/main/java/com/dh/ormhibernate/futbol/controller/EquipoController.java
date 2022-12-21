package com.dh.ormhibernate.futbol.controller;

import com.dh.ormhibernate.futbol.entity.Equipo;
import com.dh.ormhibernate.futbol.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    private EquipoService equipoService;

    @Autowired
    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public ResponseEntity<List<Equipo>> listarEquipos(){
        return ResponseEntity.ok(this.equipoService.listarEquipos());
    }
}
