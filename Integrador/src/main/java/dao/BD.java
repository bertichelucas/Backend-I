package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

    private static final Logger LOGGER= Logger.getLogger(BD.class);

    private static final String  SQL_DROP_CREATE_ODONTOLOGOS = "DROP TABLE IF EXISTS ODONTOLOGOS; " +
            "CREATE TABLE ODONTOLOGOS (ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "NUMERO_MATRICULA VARCHAR(100), NOMBRE VARCHAR(100), APELLIDO VARCHAR(100))";

    private static final String SQL_DROP_CREATE_PACIENTES = "DROP TABLE IF EXISTS PACIENTES; " +
            "CREATE TABLE PACIENTES (ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "NOMBRE VARCHAR(100) NOT NULL, " +
            "APELLIDO VARCHAR(100) NOT NULL, " +
            "DNI VARCHAR(100) NOT NULL, " +
            "FECHA_INGRESO DATE NOT NULL, " +
            "DOMICILIO_ID INT NOT NULL)";

    private static final String SQL_DROP_CREATE_DOMICILIOS = "DROP TABLE IF EXISTS DOMICILIOS;" +
            "CREATE TABLE DOMICILIOS (ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "CALLE VARCHAR(100) NOT NULL, " +
            "NUMERO INT NOT NULL, " +
            "LOCALIDAD VARCHAR(100) NOT NULL, " +
            "PROVINCIA VARCHAR(100) NOT NULL)";

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/lucasbertiche", "sa", "sa");
    }

    public static void crearTablas(){
        Connection con = null;
        try{
            LOGGER.info("Realizo la creación de las tablas");
            con = getConnection();
            Statement stmt = con.createStatement();
            stmt.execute(SQL_DROP_CREATE_DOMICILIOS);
            stmt.execute(SQL_DROP_CREATE_PACIENTES);
            stmt.execute(SQL_DROP_CREATE_ODONTOLOGOS);

        }catch (Exception e){
            LOGGER.error("Error en la creación de las tablas", e);
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException ex){
                LOGGER.error("Error al cerrar la conexión", ex);
                ex.printStackTrace();
            }
        }
    }
}
