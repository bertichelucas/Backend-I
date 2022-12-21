package com.dh.IntegradorV2.service;

import com.dh.IntegradorV2.dto.TurnoDTO;
import com.dh.IntegradorV2.exception.ResourceNotFoundException;
import com.dh.IntegradorV2.model.Turno;

import java.util.List;

public interface ITurnoService {

    public TurnoDTO guardarTurno(TurnoDTO turnoDTO);
    public void actualizarTurno(TurnoDTO turnoDTO) throws ResourceNotFoundException;

    public void eliminarTurno(Long id) throws ResourceNotFoundException;

    public TurnoDTO buscarTurno(Long id) throws ResourceNotFoundException;

    public List<TurnoDTO> buscarTodosLosTurnos();
}
