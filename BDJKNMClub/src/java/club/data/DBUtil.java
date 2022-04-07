package club.data;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtil
{
    public static Connection getConnection() {

        String driver_class = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/memberdb";
        String username = "";
        String password = "";

            Connection con = null;

        try {
            Class.forName(driver_class);

            con = DriverManager.getConnection(URL, username, password);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }
}
