package com.dh.ormhibernate.movimiento.controller;

import com.dh.ormhibernate.movimiento.entity.Movimiento;
import com.dh.ormhibernate.movimiento.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private MovimientoService ms;

    @Autowired
    public MovimientoController(MovimientoService movimientoService){
        this.ms = movimientoService;
    }

    @PostMapping
    public ResponseEntity<Movimiento> registrarMovimiento(@RequestBody Movimiento mov){
        return ResponseEntity.ok(this.ms.registrarMovimiento(mov));
    }
}
