package com.dh.IntegradorV2.service;

import com.dh.IntegradorV2.dto.TurnoDTO;
import com.dh.IntegradorV2.exception.ResourceNotFoundException;
import com.dh.IntegradorV2.model.Odontologo;
import com.dh.IntegradorV2.model.Paciente;
import com.dh.IntegradorV2.model.Turno;
import com.dh.IntegradorV2.repository.TurnoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class TurnoServiceRepository implements ITurnoService{

    private TurnoRepository turnoRepository;
    private static final Logger LOGGER= Logger.getLogger(TurnoServiceRepository.class);



    @Autowired
    public TurnoServiceRepository(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }


    @Override
    public TurnoDTO guardarTurno(TurnoDTO turnoDTO) {
        LOGGER.info("Se inicia el guardado de turno");
        Turno turno = turnoDTOaTurno(turnoDTO);
        if (this.turnoRepository.save(turno) != null){
            return turnoDTO;
        }
        return null;
    }

    @Override
    public void actualizarTurno(TurnoDTO turnoDTO) throws ResourceNotFoundException{
        LOGGER.info("Se inicia la actualizacion de turno");
        buscarTurno(turnoDTO.getId());
        Turno turno = turnoDTOaTurno(turnoDTO);
        this.turnoRepository.save(turno);
    }

    @Override
    public void eliminarTurno(Long id) throws ResourceNotFoundException{
        LOGGER.info("Se inicia el borrado de turno");
        buscarTurno(id);
        this.turnoRepository.deleteById(id);
    }

    @Override
    public TurnoDTO buscarTurno(Long id) throws ResourceNotFoundException {
        LOGGER.info("Se inicia la busqueda de turno por id");
        Optional<Turno> turno = this.turnoRepository.findById(id);
        if (turno.isPresent()){
            return turnoATurnoDTO(turno.get());
        }
        throw new ResourceNotFoundException("no se encontro el turno");
    }

    @Override
    public List<TurnoDTO> buscarTodosLosTurnos() {
        LOGGER.info("Se inicia la busqueda de todos los turnos");
        List<Turno> turnos = this.turnoRepository.findAll();
        List<TurnoDTO> turnoDTOlist = new ArrayList<>();

        for (Turno turno: turnos) {
            turnoDTOlist.add(turnoATurnoDTO(turno));
        }
        return turnoDTOlist;
    }

    private TurnoDTO turnoATurnoDTO(Turno turno){
        TurnoDTO turnoDTO = new TurnoDTO();
        //setteo
        turnoDTO.setId(turno.getId());
        turnoDTO.setPaciente(turno.getPaciente().getId());
        turnoDTO.setOdontologo(turno.getOdontologo().getId());
        turnoDTO.setFecha(turno.getFecha());
        return turnoDTO;
    }

    private Turno turnoDTOaTurno(TurnoDTO turnoDTO){
        Turno turno = new Turno();
        Paciente paciente = new Paciente();
        Odontologo odontologo = new Odontologo();

        paciente.setId(turnoDTO.getPaciente());
        odontologo.setId(turnoDTO.getOdontologo());

        //setteo el turno
        turno.setId(turnoDTO.getId());
        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);
        turno.setFecha(turnoDTO.getFecha());

        return turno;
    }
}
