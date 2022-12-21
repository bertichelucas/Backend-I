package com.dh.entrenadormvc.controller;



import com.dh.entrenadormvc.model.Entrenador;
import com.dh.entrenadormvc.service.EntrenadorService;
import com.dh.entrenadormvc.service.EntrenadorServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entrenador")

//Controller cuando tenemos tecnologia de vista en nuestro proyecto
//Rest controller cuando no tenemos tecnologia de vista, generalmente pensando en crear una API q ue va a ser consumida
//Por otra API o cliente
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    @Autowired
    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping
    public List<Entrenador> obtenerListaEntrenadores(){
        return entrenadorService.buscarEntrenadores();
    }

}
