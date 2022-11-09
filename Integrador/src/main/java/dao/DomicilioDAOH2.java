package dao;

import model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDAOH2 implements  IDao<Domicilio>{

    private static final String SQL_INSERT="INSERT INTO DOMICILIOS (CALLE, NUMERO, " +
            "LOCALIDAD, PROVINCIA) VALUES (?,?,?,?)";

    private static final String SQL_UPDATE="UPDATE DOMICILIOS SET CALLE=?," +
            "NUMERO=?, LOCALIDAD=?, PROVINCIA=? WHERE ID=?";

    private static final String SQL_DELETE="DELETE FROM DOMICILIOS WHERE ID=?";

    private static final String SQL_SELECT_ALL="SELECT * FROM DOMICILIOS";

    private static final String SQL_SELECT="SELECT * FROM DOMICILIOS WHERE ID=?";

    private static final Logger LOGGER= Logger.getLogger(DomicilioDAOH2.class);

    @Override
    public Domicilio guardar(Domicilio domicilio) {


        Connection con = null;

        try{
            LOGGER.info("Se inicia el guardado de domicilio");
            con = BD.getConnection();
            PreparedStatement ps= con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, domicilio.getCalle());
            ps.setInt(2, domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                domicilio.setId(rs.getInt(1));
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

        return domicilio;
    }

    @Override
    public Domicilio buscar(Integer id) {
        Connection con = null;
        Domicilio dom = null;
        try{
            LOGGER.info("Se inicia la búsqueda de domicilio");
            con = BD.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dom = new Domicilio(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), rs.getString(5));
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
        return dom;
    }

    @Override
    public void actualizar(Domicilio domicilio) {

        Connection con = null;
        try{
            LOGGER.info("Se inicia la actualización de domicilio");
            con = BD.getConnection();
            PreparedStatement ps= con.prepareStatement(SQL_UPDATE);
            ps.setString(1, domicilio.getCalle());
            ps.setInt(2, domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.setInt(5, domicilio.getId());
            ps.execute();


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
    }

    @Override
    public void eliminar(Integer id) {
        Connection con = null;
        try{
            LOGGER.info("Se inicia la eliminación de un domicilio");
            con = BD.getConnection();
            PreparedStatement ps= con.prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            ps.execute();

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
    }

    @Override
    public List<Domicilio> buscarTodos() {
        List<Domicilio> listaDomicilios = new ArrayList<>();
        Connection con = null;
        try{
            LOGGER.info("Se inicia la busqueda de todos los domicilios");
            con = BD.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_SELECT_ALL);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaDomicilios.add(new Domicilio(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), rs.getString(5)));
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
        return listaDomicilios;
    }
}
