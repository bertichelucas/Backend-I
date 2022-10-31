import java.sql.*;

public class GuardadoEmpleado {

    public static ResultSet guardarEmpleado(Empleado emp) throws Exception{

        Class.forName("org.h2.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "myPassword");
        Statement stmt = con.createStatement();

        String createTableEmployees = "DROP TABLE IF EXISTS EMPLEADOS;" +
                                "CREATE TABLE EMPLEADOS(ID INT PRIMARY KEY, NAME VARCHAR(255)," +
                "EDAD INT, EMPRESA VARCHAR(255));";

        String insertEmpleado = "INSERT INTO EMPLEADOS VALUES(" +
                emp.toStringSQL() + ");";

        stmt.execute(createTableEmployees);

        stmt.execute(insertEmpleado);

        String sqlQuery = "SELECT * FROM EMPLEADOS";

        return stmt.executeQuery(sqlQuery);
    }
}
