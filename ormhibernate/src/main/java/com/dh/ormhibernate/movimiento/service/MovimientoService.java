package com.dh.ormhibernate.movimiento.service;

import com.dh.ormhibernate.movimiento.entity.Movimiento;
import com.dh.ormhibernate.movimiento.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {

    private MovimientoRepository movimientoRepository;

    @Autowired
    public MovimientoService(MovimientoRepository movimientoRepository){
        this.movimientoRepository = movimientoRepository;
    }

    public List<Movimiento> obtenerListaMovimientos(){
        return movimientoRepository.findAll();
    }

    public Movimiento registrarMovimiento(Movimiento movimiento){
        return movimientoRepository.save(movimiento);
        //Sirve también para el actualizar. Si el objeto viene con id lo toma como actualizar.
    }

    public Optional<Movimiento> buscarMovimiento(Integer id){
        return movimientoRepository.findById(id);
    }

}
