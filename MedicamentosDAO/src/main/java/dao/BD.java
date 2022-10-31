package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/DAO", "sa", "sa");
    }

    public static void crearTablas(){
        Connection con = null;

        try {
            con =getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("DROP TABLE IF EXISTS MEDICAMENTOS;" +
                    "CREATE TABLE MEDICAMENTOS (ID INT PRIMARY KEY," +
                    "NOMBRE VARCHAR(100) NOT NULL, LABORATORIO VARCHAR(100) NOT NULL," +
                    "CANTIDAD INT NOT NULL, PRECIO NUMERIC(10,2) NOT NULL, CODIGO INT NOT NULL)");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
