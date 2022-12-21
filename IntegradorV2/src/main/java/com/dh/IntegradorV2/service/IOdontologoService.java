package com.dh.IntegradorV2.service;

import com.dh.IntegradorV2.exception.ResourceNotFoundException;
import com.dh.IntegradorV2.model.Odontologo;
import java.util.List;

public interface IOdontologoService {

    public Odontologo guardarOdontologo(Odontologo odontologo);
    public void actualizarOdontologo(Odontologo odontologo) throws ResourceNotFoundException;

    public void eliminarOdontologo(Long id) throws ResourceNotFoundException;

    public Odontologo buscarOdontologo(Long id) throws ResourceNotFoundException;

    public List<Odontologo> buscarTodosLosOdontologos();

}
