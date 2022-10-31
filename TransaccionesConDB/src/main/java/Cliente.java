import java.sql.*;

public class Cliente {

    private static final String SQL_CREATE = "DROP TABLE IF EXISTS USUARIO;" +
            "CREATE TABLE USUARIO (ID INT PRIMARY KEY, " +
            "NOMBRE VARCHAR(100) NOT NULL, EMAIL VARCHAR(100) NOT NULL, SUELDO NUMERIC(15,2) NOT NULL)";

    private static final String SQL_INSERT = "INSERT INTO USUARIO VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE USUARIO SET SUELDO=? WHERE EMAIL=?";

    public static void main(String[] args) throws Exception{
        Usuario usuario  = new Usuario("Pedro", "pedro@digitalhouse.com", 10d);
        
        Connection con = null;

        try {

            con = getConnection();

            Statement  stmt = con.createStatement();
            stmt.execute(SQL_CREATE);


            PreparedStatement psInsert = con.prepareStatement(SQL_INSERT);

            //Hago el insert con el prepare Statement
            psInsert.setInt(1, 1);
            psInsert.setString(2, usuario.getNombre());
            psInsert.setString(3, usuario.getEmail());
            psInsert.setDouble(4, usuario.getSueldo());

            psInsert.execute();

            //Ahora hago el update, necesito sacar el auto commit
            con.setAutoCommit(false);

            PreparedStatement psUpdate = con.prepareStatement(SQL_UPDATE);

            psUpdate.setDouble(1, usuario.subirSueldo(10));
            psUpdate.setString(2, usuario.getEmail());

            psUpdate.execute();

            con.commit();
            con.setAutoCommit(true);

            String sql = "SELECT * FROM USUARIO";

            Statement stmt2 = con.createStatement();

            ResultSet rs = stmt2.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getDouble(4));
            }

        }catch (Exception e){
            e.printStackTrace();
            con.rollback();
        }finally {
            con.close();
        }
    }

    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:"+ "./TransaccionesDB", "sa", "sa");

    }
}
