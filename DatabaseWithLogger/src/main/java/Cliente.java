import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cliente {

    private static final String SQL_DROP_CREATE = "DROP TABLE IF EXISTS USUARIOS;" +
            "CREATE TABLE USUARIOS (ID INT PRIMARY KEY, PRIMER_NOMBRE VARCHAR(100) NOT NULL," + "APELLIDO VARCHAR(100) NOT NULL, EDAD INT NOT NULL)";

    private static final String SQL_INSERT = "INSERT INTO USUARIOS VALUES " +
            "(1, 'Lucas', 'Bertiche', 23)," +
            "(2, 'Marto', 'jun', 23)," +
            "(3, 'tobi', 'guerrero', 23)," +
            "(4, 'juan', 'manuel', 23)";

    private  static final String SQL_DELETE = "DELETE FROM USUARIOS WHERE ID=3";

    private static final String SQL_SELECT = "SELECT * FROM USUARIOS";

    private static final Logger LOGGER = Logger.getLogger(Cliente.class);

    public static void main(String[] args) {

        //Preparo la conexión
        Connection connection = null;

        try {
            connection = getConnection();
            Statement stmt = connection.createStatement();

            //Creo la base de datos
            stmt.execute(SQL_DROP_CREATE);

            //Inserto los usuarios y muestro
            stmt.execute(SQL_INSERT);
            ResultSet rs = stmt.executeQuery(SQL_SELECT);
            mostrar(rs);

            //Borro el usuario 3 y muestro
            stmt.execute(SQL_DELETE);
            LOGGER.warn("Se borro el usuario con id = 3");
            ResultSet rsDel = stmt.executeQuery(SQL_SELECT);
            mostrar(rsDel);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        //crea el metodo para conectarnos

    }

    public static void mostrar(ResultSet rs) throws Exception{
        while(rs.next()){
            LOGGER.info("ID: " + rs.getInt(1) +
                    ", Primer Nombre: " + rs.getString(2) +
                    ", Apellido: " + rs.getString(3) +
                    ", Edad: " + rs.getInt(4));
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/DataWithLogger", "sa", "sa");
    }
}
