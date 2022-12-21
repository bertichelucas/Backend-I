package com.dh.IntegradorV2.service;

import com.dh.IntegradorV2.exception.ResourceNotFoundException;
import com.dh.IntegradorV2.model.Paciente;

import java.util.List;

public interface IPacienteService {

    public Paciente guardarPaciente(Paciente paciente);
    public void actualizarPaciente(Paciente paciente)  throws  ResourceNotFoundException;

    public void eliminarPaciente(Long id) throws  ResourceNotFoundException;

    public Paciente buscarPaciente(Long id) throws ResourceNotFoundException;

    public List<Paciente> buscarTodosLosPacientes();

    public Paciente buscarPacientePorEmail(String email) throws ResourceNotFoundException;
}
