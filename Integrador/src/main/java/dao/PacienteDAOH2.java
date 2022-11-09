package dao;

import model.Domicilio;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



public class PacienteDAOH2 implements IDao<Paciente>{

    private static final String SQL_SELECT="SELECT * FROM PACIENTES WHERE ID=?";

    private static final Logger LOGGER= Logger.getLogger(DomicilioDAOH2.class);

    @Override
    public Paciente guardar(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente buscar(Integer id) {
        Connection con = null;
        Paciente paciente = null;
        try{
            LOGGER.info("Se inicia la busqueda de paciente");
            con = BD.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            DomicilioDAOH2 domDAO = new DomicilioDAOH2();
            while(rs.next()){
                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getDate(5).toLocalDate(), domDAO.buscar(rs.getInt(6)));
            }

        }catch (Exception e){
            LOGGER.error("Error: " + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public void actualizar(Paciente paciente) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }
}
