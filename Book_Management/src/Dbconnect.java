import java.util.*;
import java.sql.*;

public class Dbconnect {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/practice";
    private static final String USER = "root";
    private static final String PASSWORD = "1875";
    public static Connection getConnection() {
    	try {
    		Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
    		System.out.println("Connection to the database was successfull!...");
    		return con;
    	}
    	catch(SQLException e) {
    		System.out.println("Failed to connect to the database...Error:" + e.getMessage());
    		return null;
    	}
    }
}
