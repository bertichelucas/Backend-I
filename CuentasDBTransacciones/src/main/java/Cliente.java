import java.sql.*;

public class Cliente {

    private static final String SQL_CREATE = "DROP TABLE IF EXISTS CUENTAS;" +
            "CREATE TABLE CUENTAS (" +
            "ID INT PRIMARY KEY, NUMERO_CUENTA INT NOT NULL, " +
            "NOMBRE VARCHAR(100) NOT NULL, SALDO NUMERIC(10,2) NOT NULL)";

    private static final String SQL_INSERT = "INSERT INTO CUENTAS VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE CUENTAS SET SALDO=? WHERE ID=?";

    public static void main(String[] args) {
        Connection con = null;

        try {
            con = getConnection();

            //Creo la base de datos
            Statement stmt = con.createStatement();
            stmt.execute(SQL_CREATE);

            //Hago el insert a mi base de datos
            PreparedStatement psmt = con.prepareStatement(SQL_INSERT);
            psmt.setInt(1, 1);
            psmt.setInt(2,14214);
            psmt.setString(3, "Juan Carlos");
            psmt.setDouble(4, 123d);

            psmt.execute();

            //Hago el update de datos
            con.setAutoCommit(false);

            PreparedStatement psmtUpdate = con.prepareStatement(SQL_UPDATE);

            psmtUpdate.setDouble(1, 424d);
            psmtUpdate.setInt(2, 1);

            psmtUpdate.execute();

            con.commit();

            con.setAutoCommit(true);

            //Me traigo los datos para comprobar que estén correctos

            Statement stmtSelect = con.createStatement();

            ResultSet rs = stmtSelect.executeQuery("SELECT * FROM CUENTAS");

            while (rs.next()){
                System.out.println(rs.getDouble(4));
            }

        }catch (Exception e){
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();

        }finally {
            try {
                con.close();
            }catch (Exception e2){

            }
        }
    }

    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/Transaccion", "sa", "sa");
    }
}
