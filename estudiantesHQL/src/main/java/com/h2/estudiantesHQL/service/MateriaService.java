package com.h2.estudiantesHQL.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.h2.estudiantesHQL.entity.Estudiante;
import com.h2.estudiantesHQL.entity.EstudianteDTO;
import com.h2.estudiantesHQL.entity.Materia;
import com.h2.estudiantesHQL.entity.MateriaDTO;
import com.h2.estudiantesHQL.repository.EstudianteRepository;
import com.h2.estudiantesHQL.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MateriaService implements IMateriaService{

    private MateriaRepository materiaRepository;
    ObjectMapper mapper;

    @Autowired
    public MateriaService(MateriaRepository materiaRepository, ObjectMapper mapper) {
        this.materiaRepository = materiaRepository;
        this.mapper = mapper;
    }

    @Override
    public MateriaDTO crearMateria(MateriaDTO materiaDTO) {
        Materia materia = mapper.convertValue(materiaDTO, Materia.class);
        materiaRepository.save(materia);
        return materiaDTO;
    }

    @Override
    public MateriaDTO leerMateria(Long id) {
        Optional<Materia> materia = materiaRepository.findById(id);
        MateriaDTO materiaDTO = null;
        if (materia.isPresent()){
            materiaDTO = mapper.convertValue(materia, MateriaDTO.class);
        }
        return materiaDTO;
    }

    @Override
    public void modificarMateria(MateriaDTO materiaDTO) {
        Materia materia = mapper.convertValue(materiaDTO, Materia.class);
        materiaRepository.save(materia);
    }

    @Override
    public void eliminarMateria(Long id) {
        materiaRepository.deleteById(id);
    }

    @Override
    public Set<MateriaDTO> getTodos() {
        List<Materia> materias = materiaRepository.findAll();
        Set<MateriaDTO> setMaterias = new HashSet<>();

        for (Materia materia: materias) {
            setMaterias.add(mapper.convertValue(materia, MateriaDTO.class));
        }
        return setMaterias;
    }
}
