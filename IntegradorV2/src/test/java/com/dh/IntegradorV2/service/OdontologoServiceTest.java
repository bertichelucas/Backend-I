package com.dh.IntegradorV2.service;

import com.dh.IntegradorV2.model.Domicilio;
import com.dh.IntegradorV2.model.Odontologo;
import com.dh.IntegradorV2.model.Paciente;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    Odontologo odontologoAGuardar = new Odontologo("12314", "Carlos", "Bilardo");

    @Test
    @Order(1)
    public void guardarOdontologoTest() {
        //GIVEN

        //WHEN
        Odontologo odontologo = odontologoService.guardarOdontologo(odontologoAGuardar);
        //THEN
        Assertions.assertNotNull(odontologo);
    }

    @Test
    @Order(2)
    public void buscarTodosLosOdontologosTest() {
        //GIVEN

        //WHEN
        List<Odontologo> listaOdontologos = odontologoService.buscarTodosLosOdontologos();

        //THEN
        Assertions.assertTrue(listaOdontologos.size() >= 1);
    }

    @Test
    @Order(3)
    public void buscarOdontologoPorIdTest() {
        //GIVEN
        Odontologo odontologo = null;
        //WHEN
        List<Odontologo> odontologos = odontologoService.buscarTodosLosOdontologos();
        try {
            odontologo = odontologoService.buscarOdontologo(odontologos.get(odontologos.size() - 1).getId());
        } catch (Exception e) {

        }
        //THEN
        Assertions.assertEquals(odontologo.getNumeroMatricula(), odontologoAGuardar.getNumeroMatricula());
    }

    @Test
    @Order(4)
    public void actualizarOdontologoTest() {
        //GIVEN
        List<Odontologo> odontologos = odontologoService.buscarTodosLosOdontologos();
        Odontologo odontologoAActualizar = new Odontologo(odontologos.get(odontologos.size() - 1).getId(), "3123123", "Carlos", "Bilardo");

        Odontologo odontologoBuscado = null;

        try {
            //WHEN
            odontologoService.actualizarOdontologo(odontologoAActualizar);
            odontologoBuscado = odontologoService.buscarOdontologo(odontologos.get(odontologos.size() - 1).getId());
        } catch (Exception e) {

        }


        //THEN
        Assertions.assertEquals(odontologoAActualizar.getNumeroMatricula(), odontologoBuscado.getNumeroMatricula());
    }

    @Test
    @Order(5)
    public void borrarOdontologo() {
        List<Odontologo> odontologos = odontologoService.buscarTodosLosOdontologos();

        try {
            odontologoService.eliminarOdontologo(odontologos.get(odontologos.size() - 1).getId());
        } catch (Exception e) {
        }

        Assertions.assertEquals(odontologos.size(), odontologoService.buscarTodosLosOdontologos().size() + 1);
    }
}