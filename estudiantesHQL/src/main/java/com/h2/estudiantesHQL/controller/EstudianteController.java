package com.h2.estudiantesHQL.controller;

import com.h2.estudiantesHQL.entity.EstudianteDTO;
import com.h2.estudiantesHQL.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> crearEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        EstudianteDTO resultado =  estudianteService.crearEstudiante(estudianteDTO);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/{id}")
    public EstudianteDTO getEstudiante(@PathVariable("id") Long id){
        return estudianteService.leerEstudiante(id);
    }

    @PutMapping
    public ResponseEntity<EstudianteDTO> modificarEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        estudianteService.modificarEstudiante(estudianteDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EstudianteDTO> eliminarEstudiante(@PathVariable("id") Long id){
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Set<EstudianteDTO>> listarTodos(){
        return ResponseEntity.ok(estudianteService.getTodos());
    }

}
