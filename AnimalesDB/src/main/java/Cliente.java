import java.sql.*;

public class Cliente {

    public static void main(String[] args) {

        //conectarme a la base de datos
        Connection con;
        try {
            con = getConnection();

            //Preparo el mensaje a la base de datos
            Statement stmt = con.createStatement();
            stmt.execute("DROP TABLE IF EXISTS ANIMALES;" +
                    "CREATE TABLE ANIMALES (ID INT PRIMARY KEY," +
                    " NOMBRE VARCHAR(100) NOT NULL," +
                    " TIPO VARCHAR(100) NOT NULL)");

            stmt.execute("INSERT INTO ANIMALES VALUES (1,'Coco','Gato')," +
                    "(2,'Titan','Perro'),"+ "(3,'Dino','Loro')," +"(4,'Titanv2','Perro')," +
                    "(5,'Croco','Croco')");

            ResultSet rs = stmt.executeQuery("SELECT * FROM ANIMALES");

            while (rs.next()){
                System.out.println("Nombre: " + rs.getString(2) + " y Tipo: " + rs.getString(3));
            }



        } catch (Exception e){
            //Aqui podria ir un logger de tipo error
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/AnimalesDB", "sa", "sa");
    }
}
