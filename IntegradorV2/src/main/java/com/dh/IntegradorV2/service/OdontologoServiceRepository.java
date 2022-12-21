package com.dh.IntegradorV2.service;

import com.dh.IntegradorV2.exception.ResourceNotFoundException;
import com.dh.IntegradorV2.model.Odontologo;
import com.dh.IntegradorV2.repository.OdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class OdontologoServiceRepository implements IOdontologoService{

    private OdontologoRepository odontologoRepository;
    private static final Logger LOGGER= Logger.getLogger(OdontologoServiceRepository.class);

    @Autowired
    public OdontologoServiceRepository(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }


    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        LOGGER.info("Se inicia el guardado de un odontologo");
        return this.odontologoRepository.save(odontologo);
    }

    @Override
    public void actualizarOdontologo(Odontologo odontologo) throws ResourceNotFoundException{
        LOGGER.info("Se inicia la actualizacion de un odontologo");
        buscarOdontologo(odontologo.getId());
        this.odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException{
        LOGGER.info("Se inicia el borrado de un odontologo");
        buscarOdontologo(id);
        this.odontologoRepository.deleteById(id);
    }

    @Override
    public Odontologo buscarOdontologo(Long id) throws ResourceNotFoundException{
        LOGGER.info("Se inicia la busqueda de odontologo por id");
        Optional<Odontologo> odontologo = this.odontologoRepository.findById(id);
        if(odontologo.isPresent()){
            return odontologo.get();
        }
        throw new ResourceNotFoundException("odontologo no encontrado");
    }

    @Override
    public List<Odontologo> buscarTodosLosOdontologos() {
        LOGGER.info("Se inicia la busqueda de todos los odontologos");
        return this.odontologoRepository.findAll();
    }
}
