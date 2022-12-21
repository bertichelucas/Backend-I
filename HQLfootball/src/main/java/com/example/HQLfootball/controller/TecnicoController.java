package com.example.HQLfootball.controller;

import com.example.HQLfootball.entity.Tecnico;
import com.example.HQLfootball.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    private TecnicoService tecnicoService;

    @Autowired
    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    @PostMapping
    public ResponseEntity<Tecnico> registrarTecnico(@RequestBody Tecnico tecnico){
        return ResponseEntity.ok(tecnicoService.guardarTecnico(tecnico));
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Tecnico> buscarTecnicoPorNombre(@PathVariable("nombre") String nombre){
        Optional<Tecnico> tecnicoBuscado = tecnicoService.buscarTecnicoPorNombre(nombre);
        if (tecnicoBuscado.isPresent()){
            return ResponseEntity.ok(tecnicoBuscado.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
