package com.dh.IntegradorV2.controller;


import com.dh.IntegradorV2.dto.TurnoDTO;
import com.dh.IntegradorV2.exception.ResourceNotFoundException;
import com.dh.IntegradorV2.model.Turno;
import com.dh.IntegradorV2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private ITurnoService turnoService;
    private IPacienteService pacienteService;
    private IOdontologoService odontologoService;

    @Autowired
    public TurnoController(ITurnoService turnoService, IPacienteService pacienteService, IOdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @GetMapping(path=  "/{id}")
    public ResponseEntity<TurnoDTO> buscarTurnoPorId(@PathVariable("id") Long id)  throws ResourceNotFoundException{
        TurnoDTO turnoDTO = turnoService.buscarTurno(id);
        return ResponseEntity.ok(turnoDTO);
    }

    @GetMapping
    public ResponseEntity<List<TurnoDTO>> listarLosTurnos(){
        return  ResponseEntity.ok(turnoService.buscarTodosLosTurnos());
    }

    @PostMapping
    public ResponseEntity<TurnoDTO> registrarTurno(@RequestBody TurnoDTO turnoDTO)  throws ResourceNotFoundException{

        ResponseEntity<TurnoDTO> respuesta;
        pacienteService.buscarPaciente(turnoDTO.getPaciente());
        odontologoService.buscarOdontologo(turnoDTO.getOdontologo());

        TurnoDTO turnoDTOres = this.turnoService.guardarTurno(turnoDTO);
        if (turnoDTOres != null){
            return ResponseEntity.ok(turnoDTOres);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<TurnoDTO> borrarTurno(@PathVariable("id") Long id)  throws ResourceNotFoundException {
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<TurnoDTO> actualizarTurno(@RequestBody TurnoDTO turnoDTO)  throws ResourceNotFoundException{

        ResponseEntity<TurnoDTO> respuesta;
        //Si cualquiera de los sig dos no encuentra me tira error y la ejecución no sigue
        pacienteService.buscarPaciente(turnoDTO.getPaciente());
        odontologoService.buscarOdontologo(turnoDTO.getOdontologo());

        turnoService.actualizarTurno(turnoDTO);

        return ResponseEntity.ok().build();
    }
}
