package com.dh.IntegradorV2.controller;

import com.dh.IntegradorV2.exception.ResourceNotFoundException;
import com.dh.IntegradorV2.model.Odontologo;
import com.dh.IntegradorV2.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {

    private IOdontologoService odontologoService;

    @Autowired
    public OdontologoController(IOdontologoService odontologoService){
        this.odontologoService = odontologoService;
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Odontologo> buscarOdontologoPorId(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Odontologo odontologo = this.odontologoService.buscarOdontologo(id);
        return ResponseEntity.ok(odontologo);
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologos(){
        return ResponseEntity.ok(this.odontologoService.buscarTodosLosOdontologos());
    }

    @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo){
        Odontologo odontologoRegistrado = this.odontologoService.guardarOdontologo(odontologo);
        if (odontologoRegistrado != null){
            return ResponseEntity.ok(odontologoRegistrado);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Odontologo> borrarOdontologo(@PathVariable("id") Long id) throws ResourceNotFoundException{
        Odontologo odontologo = this.odontologoService.buscarOdontologo(id);
        this.odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo) throws ResourceNotFoundException{
        Odontologo odontologoBuscado = this.odontologoService.buscarOdontologo(odontologo.getId());
        this.odontologoService.actualizarOdontologo(odontologo);
        return ResponseEntity.ok().build();
    }
}
