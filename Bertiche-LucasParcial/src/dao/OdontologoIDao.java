package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoIDao implements IDao<Odontologo>{

    private static final String SQL_INSERT= "INSERT INTO ODONTOLOGOS (NUMERO_MATRICULA, NOMBRE, APELLIDO)" +
            " VALUES (?,?,?)";

    private static final String SQL_SELECT_ALL= "SELECT * FROM ODONTOLOGOS";

    private static final Logger LOGGER= Logger.getLogger(OdontologoIDao.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection con = null;
        LOGGER.info("Realizo el guardado del odontologo");
        try {
            con = BD.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, odontologo.getNumeroMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                odontologo.setId(rs.getInt(1));
            }


        }catch (Exception e){
            LOGGER.error("Error en el guardado del odontologo", e);
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException ex){
                LOGGER.error("Error al cerrar la conexion", ex);
                ex.printStackTrace();
            }
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection con = null;
        LOGGER.info("Realizo la busqueda de todos los odontologos");
        List<Odontologo> listaOdontologos = new ArrayList<Odontologo>();
        try {
            con = BD.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                listaOdontologos.add(new Odontologo(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4)));
            }


        }catch (Exception e){
            LOGGER.error("Error en la busqueda de todos los odontologos", e);
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException ex){
                LOGGER.error("Error al cerrar la conexion", ex);
                ex.printStackTrace();
            }
        }
        return listaOdontologos;
    }

    /************************************ EXTRA ************************************/

    private static final String SQL_DELETE="DElETE FROM ODONTOLOGOS WHERE ID=?";

    private static final String SQL_UPDATE="UPDATE ODONTOLOGOS SET NUMERO_MATRICULA=?, " +
            "NOMBRE=?, APELLIDO=? WHERE ID=?";

    private static final String SQL_SELECT="SELECT * FROM ODONTOLOGOS WHERE ID=?";

    @Override
    public void eliminar(Integer id) {
        Connection con = null;
        LOGGER.info("Realizo el delete de un odontologo");
        try {
            con = BD.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            ps.execute();

        }catch (Exception e){
            LOGGER.error("Error en el delete de un odontologo", e);
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException ex){
                LOGGER.error("Error al cerrar la conexion", ex);
                ex.printStackTrace();
            }
        }
    }


    @Override
    public void actualizar(Odontologo odontologo) {
        Connection con = null;
        LOGGER.info("Realizo el update de un odontologo");
        try {
            con = BD.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, odontologo.getNumeroMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.setInt(4, odontologo.getId());
            ps.execute();



        }catch (Exception e){
            LOGGER.error("Error en el update de un odontologo", e);
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException ex){
                LOGGER.error("Error al cerrar la conexion", ex);
                ex.printStackTrace();
            }
        }
    }


    @Override
    public Odontologo buscar(Integer id) {
        Connection con = null;
        LOGGER.info("Realizo la busqueda de un odontologo");
        Odontologo od = null;
        try {
            con = BD.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                od =new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }

        }catch (Exception e){
            LOGGER.error("Error en la busqueda de un odontolgo", e);
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException ex){
                LOGGER.error("Error al cerrar la conexion", ex);
                ex.printStackTrace();
            }
        }
        return od;
    }


}
