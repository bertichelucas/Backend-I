package com.dh.ormhibernate.movimiento.service;

import com.dh.ormhibernate.movimiento.entity.Profesor;
import com.dh.ormhibernate.movimiento.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    private ProfesorRepository profesorRepository;

    @Autowired
    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public Profesor registrarProfesor(Profesor profesor){
        return this.profesorRepository.save(profesor);
    }

    public List<Profesor> listarProfesores() {
        return this.profesorRepository.findAll();
    }
}
