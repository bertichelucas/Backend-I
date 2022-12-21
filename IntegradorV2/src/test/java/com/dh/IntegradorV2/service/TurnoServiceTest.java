package com.dh.IntegradorV2.service;

import com.dh.IntegradorV2.dto.TurnoDTO;
import com.dh.IntegradorV2.model.Domicilio;
import com.dh.IntegradorV2.model.Odontologo;
import com.dh.IntegradorV2.model.Paciente;
import com.dh.IntegradorV2.model.Turno;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class TurnoServiceTest {

    @Autowired
    private ITurnoService turnoService;

    @Autowired
    private IPacienteService pacienteService;

    @Autowired
    private IOdontologoService odontologoService;




    @Test
    @Order(1)
    public void guardarTurnoTest(){
        //GIVEN
        pacienteService.guardarPaciente(new Paciente());
        odontologoService.guardarOdontologo(new Odontologo());
        List<Paciente> pacientes = pacienteService.buscarTodosLosPacientes();
        List<Odontologo> odontologos = odontologoService.buscarTodosLosOdontologos();

        //WHEN
        TurnoDTO turnoDTO = turnoService.guardarTurno(new TurnoDTO(pacientes.get(pacientes.size() -1).getId(), odontologos.get(odontologos.size() - 1).getId(), LocalDate.now()));
        //THEN
        Assertions.assertNotNull(turnoDTO);
    }

    @Test
    @Order(2)
    public void buscarTodosLosTurnosTest(){
        //GIVEN

        //WHEN
        List<TurnoDTO> listaTurnos = turnoService.buscarTodosLosTurnos();

        //THEN
        Assertions.assertTrue(listaTurnos.size() >= 1);
    }

    @Test
    @Order(3)
    public void buscarTurnoPorIdTest(){
        //GIVEN
        TurnoDTO turno = null;
        //WHEN
        List<TurnoDTO> turnos = turnoService.buscarTodosLosTurnos();
        try {
            turno = turnoService.buscarTurno(turnos.get(turnos.size() -1).getId());
        }catch (Exception e){

        }
        //THEN
        Assertions.assertNotNull(turno);
    }

    @Test
    @Order(4)
    public void actualizarTurnoTest(){
        //GIVEN
        List<TurnoDTO> turnos  = turnoService.buscarTodosLosTurnos();
        TurnoDTO turnoOriginal = turnos.get(turnos.size() - 1);
        LocalDate date =  LocalDate.now();
        TurnoDTO turnoAActualizar = new TurnoDTO(turnoOriginal.getId(),turnoOriginal.getPaciente(), turnoOriginal.getOdontologo(),date);

        TurnoDTO turnoBuscado = null;

        try {
            //WHEN
            turnoService.actualizarTurno(turnoAActualizar);
            turnoBuscado = turnoService.buscarTurno(turnoOriginal.getId());
        } catch (Exception e){

        }


        //THEN
        Assertions.assertEquals(turnoBuscado.getFecha(), date);
    }

    @Test
    @Order(5)
    public void borrarTurnoTest(){
        List<TurnoDTO> turnos = turnoService.buscarTodosLosTurnos();

        try {
            turnoService.eliminarTurno(turnos.get(turnos.size()-1).getId());
        }catch (Exception e) {
        }

        Assertions.assertEquals(turnos.size(), turnoService.buscarTodosLosTurnos().size() + 1);
    }
}
