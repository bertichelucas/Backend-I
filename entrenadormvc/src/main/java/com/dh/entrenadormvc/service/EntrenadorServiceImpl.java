package com.dh.entrenadormvc.service;

import com.dh.entrenadormvc.model.Entrenador;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EntrenadorServiceImpl implements  EntrenadorService{


    @Override
    public List<Entrenador> buscarEntrenadores() {
        return Arrays.asList(
                new Entrenador("Carlos"),
                new Entrenador("Ezequiel")
        );
    }
}
