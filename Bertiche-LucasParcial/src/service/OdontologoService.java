package service;

import dao.IDao;
import model.Odontologo;

import java.util.List;



public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao){
        this.odontologoIDao  = odontologoIDao;
    }

    public Odontologo guardar(Odontologo odontologo){
        return this.odontologoIDao.guardar(odontologo);
    }

    public void eliminar(Integer id){
        this.odontologoIDao.eliminar(id);
    }

    public void actualizar(Odontologo odontologo){
        this.odontologoIDao.actualizar(odontologo);
    }

    public Odontologo buscar(Integer id){
        return this.odontologoIDao.buscar(id);
    }

    public List<Odontologo> buscarTodos(){
        return this.odontologoIDao.buscarTodos();
    }

}
