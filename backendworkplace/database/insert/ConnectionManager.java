package sku.lesson.db.try1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	public static Connection getConnection() {
		Connection con = null;
		String id = "root";
		String pwd = "1q2w3e4r";
		String driver = "com.mysql.cj.jdbc.Driver";
		String jdbcURL = "jdbc:mysql://localhost:3306/sku";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(jdbcURL,id,pwd);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(ResultSet rs, Statement stmt, Connection con) {
		
	}
}
