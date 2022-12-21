package com.dh.ormhibernate.futbol.service;

import com.dh.ormhibernate.futbol.entity.Equipo;
import com.dh.ormhibernate.futbol.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    private EquipoRepository equipoRepository;

    @Autowired
    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public List<Equipo> listarEquipos(){
        return this.equipoRepository.findAll();
    }
}
