package com.dh.IntegradorV2.service;

import com.dh.IntegradorV2.model.Domicilio;
import com.dh.IntegradorV2.model.Paciente;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class PacienteServiceTest {

   @Autowired
   private IPacienteService pacienteService;

   Paciente pacienteAGuardar = new Paciente("Lucas", "Bertiche", "3123123", LocalDate.now(),
           new Domicilio("calle a", 421, "caballito", "buenos aires"),"bertichelucas@gmail.com");

   @Test
   @Order(1)
   public void guardarPacienteTest(){
      //GIVEN

      //WHEN
      Paciente pacienteGuardado = pacienteService.guardarPaciente(pacienteAGuardar);
      //THEN
      Assertions.assertNotNull(pacienteGuardado);
   }

   @Test
   @Order(2)
   public void buscarTodosLosPacientesTest(){
      //GIVEN

      //WHEN
      List<Paciente> listaPacientes = pacienteService.buscarTodosLosPacientes();

      //THEN
      Assertions.assertTrue(listaPacientes.size() >= 1);
   }

   @Test
   @Order(3)
   public void buscarPacientePorIdTest(){
      //GIVEN
      Paciente paciente = null;
      //WHEN
      List<Paciente> pacientes = pacienteService.buscarTodosLosPacientes();
      try {
         paciente = pacienteService.buscarPaciente(pacientes.get(pacientes.size() - 1).getId());
      }catch (Exception e){

      }
      //THEN
      Assertions.assertEquals(paciente.getEmail(), pacienteAGuardar.getEmail());
   }

   @Test
   @Order(4)
   public void actualizarPacienteTest(){
      //GIVEN
      List<Paciente> pacientes = pacienteService.buscarTodosLosPacientes();
      Paciente pacienteAActualizar = new Paciente(pacientes.get(pacientes.size() - 1).getId(), "Lucas", "Bertiche", "3123123", LocalDate.now(),
              new Domicilio("calle a", 421, "caballito", "buenos aires"),"actualizado@gmail.com");

      Paciente pacienteBuscado = null;

      try {
         //WHEN
         pacienteService.actualizarPaciente(pacienteAActualizar);
         pacienteBuscado = pacienteService.buscarPaciente(pacientes.get(pacientes.size() - 1).getId());
      } catch (Exception e){

      }


      //THEN
      Assertions.assertEquals(pacienteAActualizar.getEmail(), pacienteBuscado.getEmail());
   }

   @Test
   @Order(5)
   public void borrarPaciente(){
      List<Paciente> pacientes = pacienteService.buscarTodosLosPacientes();

      try {
         pacienteService.eliminarPaciente(pacientes.get(pacientes.size() - 1).getId());
      }catch (Exception e) {
      }

      Assertions.assertEquals(pacientes.size(), pacienteService.buscarTodosLosPacientes().size() + 1);
   }
}
