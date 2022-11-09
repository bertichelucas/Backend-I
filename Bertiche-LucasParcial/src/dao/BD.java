package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

    private static final Logger LOGGER= Logger.getLogger(BD.class);

    private static final String  SQL_DROP_CREATE = "DROP TABLE IF EXISTS ODONTOLOGOS; " +
            "CREATE TABLE ODONTOLOGOS (ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "NUMERO_MATRICULA VARCHAR(100), NOMBRE VARCHAR(100), APELLIDO VARCHAR(100))";

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/lucasbertiche", "sa", "sa");
    }

    public static void crearTabla(){
        Connection con = null;
        try {
            LOGGER.info("Realizo la creación de la tabla");
            con = getConnection();

            Statement stmt = con.createStatement();
            stmt.execute(SQL_DROP_CREATE);


        }catch (Exception e){
            LOGGER.error("Error en la creación de la tabla", e);
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
