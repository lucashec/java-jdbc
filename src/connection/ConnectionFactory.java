package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; 
    private static final String URL = "jdbc:mysql:localhost:3306/dbloja"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "1216"; 
    
    public static Connection getConnection(){
        try {
            
            Class.forName(DRIVER);           
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Connection failed", ex);
        }
    }
    
    public static void closeConnection(Connection con){
        if(con != null){
            try {
                con.close();
                        } catch (SQLException ex) {
                System.err.println("Error:"+ex);
            }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        if(con != null){
            try {
                stmt.close();
                        } catch (SQLException ex) {
                System.err.println("Error:"+ex);
            }
        }
        closeConnection(con);
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        if(con != null){
            try {
                rs.close();
                        } catch (SQLException ex) {
                System.err.println("Error:"+ex);
            }
        }
        closeConnection(con, stmt);
    }
}
