package service;

import dao.IDao;
import lombok.AllArgsConstructor;
import model.Paciente;

import java.util.List;

@AllArgsConstructor
public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public Paciente guardarPaciente(Paciente paciente){
        return pacienteIDao.guardar(paciente);
    }

    public void actualizarPaciente(Paciente paciente){
        pacienteIDao.actualizar(paciente);
    }

    public void eliminarPaciente(Integer id){
        pacienteIDao.eliminar(id);
    }

    public Paciente buscarPaciente(Integer id){
        return pacienteIDao.buscar(id);
    }

    public List<Paciente> buscarTodosLosPacientes(){
        return pacienteIDao.buscarTodos();
    }

}
