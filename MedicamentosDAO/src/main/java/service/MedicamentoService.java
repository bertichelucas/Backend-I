package service;

import dao.IDao;
import dao.MedicamentoDAOH2;
import model.Medicamento;

public class MedicamentoService {

    private IDao<Medicamento> medicamentoIDao;

    public MedicamentoService(){
        this.medicamentoIDao = new MedicamentoDAOH2();
    }

    public Medicamento guardar(Medicamento medicamento){
        return this.medicamentoIDao.guardar(medicamento);
    }

    public Medicamento buscar(Integer id){
        return this.medicamentoIDao.buscar(id);
    }
}
