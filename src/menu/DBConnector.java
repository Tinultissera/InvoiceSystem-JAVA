package menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    //get connection to database
    static Connection getConnection()throws ClassNotFoundException, SQLException{
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc_company", "root", "");
        return con;
    }
}
