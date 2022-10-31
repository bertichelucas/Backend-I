package dao;

import model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MedicamentoDAOH2 implements IDao<Medicamento>{

    private static final Logger LOGGER = Logger.getLogger(MedicamentoDAOH2.class);

    private static final String SQL_INSERT = "INSERT INTO MEDICAMENTOS VALUES (?,?,?,?,?,?)";

    private static final String SQL_SELECT = "SELECT * FROM MEDICAMENTOS WHERE ID=?";


    @Override
    public Medicamento guardar(Medicamento medicamento) {

        LOGGER.info("Se inicio un pedido de incorporación de medicamento");

        Connection con = null;
        try {
            //Me conecto a la base
            con = BD.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL_INSERT);
        ps.setInt(1, medicamento.getId());
        ps.setString(2, medicamento.getNombre());
        ps.setString(3, medicamento.getLaboratorio());
        ps.setInt(4, medicamento.getCantidad());
        ps.setDouble(5,medicamento.getPrecio());
        ps.setInt(6, medicamento.getCodigo());

        ps.execute();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public Medicamento buscar(Integer id) {
        LOGGER.info("Se inicia proceso de busqueda");

        Medicamento  md = null;
        Connection con = null;
        try {
            //Me conecto a la base
            con = BD.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, 1);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                md = new Medicamento(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getInt(4), rs.getDouble(5),rs.getInt(6));
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return null;
    }
}
