package com.dh.IntegradorV2.service;

import com.dh.IntegradorV2.exception.ResourceNotFoundException;
import com.dh.IntegradorV2.model.Paciente;
import com.dh.IntegradorV2.repository.PacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class PacienteServiceRepository implements IPacienteService {

    private PacienteRepository pacienteRepository;
    private static final Logger LOGGER= Logger.getLogger(PacienteServiceRepository.class);

    @Autowired
    public PacienteServiceRepository(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente){
        LOGGER.info("Se inicia el guardado de un paciente");
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente buscarPaciente(Long id) throws ResourceNotFoundException{
        LOGGER.info("Se inicia la busqueda de un paciente por id");
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isPresent()){
            return paciente.get();
        }
        throw new ResourceNotFoundException("paciente no encontrado");
    }

    @Override
    public List<Paciente> buscarTodosLosPacientes() {
        LOGGER.info("Se inicia la busqueda de todos los pacientes");
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente buscarPacientePorEmail(String email) throws ResourceNotFoundException {
        LOGGER.info("Se inicia la  busqueda de un paciente por email");
        Optional<Paciente> paciente = pacienteRepository.findByEmail(email);
        if (paciente.isPresent()){
            return paciente.get();
        }
        throw new ResourceNotFoundException("paciente no encontrado");
    }

    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException{
        LOGGER.info("Se inicia la eliminacion de un paciente");
        buscarPaciente(id);
        pacienteRepository.deleteById(id);
    }

    public void actualizarPaciente(Paciente paciente)  throws ResourceNotFoundException{
        LOGGER.info("Se inicia la actualizacion de un paciente");
        buscarPaciente(paciente.getId());
        pacienteRepository.save(paciente);
    }


}
