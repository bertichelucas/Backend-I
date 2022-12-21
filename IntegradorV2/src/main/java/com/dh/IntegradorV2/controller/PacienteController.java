package com.dh.IntegradorV2.controller;

import com.dh.IntegradorV2.exception.ResourceNotFoundException;
import com.dh.IntegradorV2.model.Paciente;
import com.dh.IntegradorV2.service.IPacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService){
        this.pacienteService = pacienteService;
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable("id") Long id)  throws ResourceNotFoundException {
        Paciente paciente = this.pacienteService.buscarPaciente(id);
        return ResponseEntity.ok(paciente);

    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes(){
        return ResponseEntity.ok(this.pacienteService.buscarTodosLosPacientes());
    }

    @GetMapping(path="/email/{email}")
    public ResponseEntity<Paciente> buscarPacientePorEmail(@PathVariable("email") String email)  throws ResourceNotFoundException{
        Paciente paciente = this.pacienteService.buscarPacientePorEmail(email);
        return ResponseEntity.ok(paciente);
    }

    @PostMapping
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente){
        Paciente pacienteGuardado = this.pacienteService.guardarPaciente(paciente);
        if (pacienteGuardado !=  null){
            return ResponseEntity.ok(paciente);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente)  throws ResourceNotFoundException{
        this.pacienteService.actualizarPaciente(paciente);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Paciente> borrarPaciente(@PathVariable("id") Long id)  throws ResourceNotFoundException{
        Paciente pacienteBuscado = this.pacienteService.buscarPaciente(id);
        this.pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok().build();
    }

}
