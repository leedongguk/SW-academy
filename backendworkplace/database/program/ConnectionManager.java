package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
   public static Connection getConnection() throws SQLException, ClassNotFoundException { //예외처리 구문 2 : 나중으로 미룰게
      String id = "root";
      String pwd = "1234";
      String driver = "com.mysql.cj.jdbc.Driver";
      String jdbcURL = "jdbc:mysql://localhost:3306/sku"; // 프로토콜(주 + 보조)/ 포트번호 / 이름
      Class.forName(driver);
      
      Connection con = DriverManager.getConnection(jdbcURL, id, pwd);// 예외 발생 구문

      return con;
      
   }
   
   public static void closeConnection(ResultSet rs, Statement stmt, Connection con) {
      if(rs!=null) {
         try {
            rs.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
      if(stmt!=null) {
         try {
            stmt.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
      if(con!=null) {
         try {
            con.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }
}