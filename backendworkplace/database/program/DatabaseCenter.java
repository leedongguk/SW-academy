package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseCenter {
	
	public static void main(String[] args) {
		//connectDatabase 호출
      DatabaseCenter dc = new DatabaseCenter();
      
      dc.testQuery();
      
   }
   
   public void testQuery() {
      //DAO의 select 호출 코드 작성
	   String a;
	   Scanner in = new Scanner(System.in);
	   BookDAO dao=new BookDAO();
       a = in.nextLine();
       dao.input(a);
     // dao.select("select * from book");
   }
   
   public void test() {
      try {
         this.connectDatabase();
      }catch(SQLException e) {
         e.printStackTrace();
      }catch(ClassNotFoundException e) {
         e.printStackTrace();
      }
   }
   public void connectDatabase() throws SQLException, ClassNotFoundException { //예외처리 구문 2 : 나중으로 미룰게
      String id = "root";
      String pwd = "1234";
      String driver = "com.mysql.cj.jdbc.Driver";
      String jdbcURL = "jdbc:mysql://localhost:3306/sku"; // 프로토콜(주 + 보조)/ 포트번호 / 이름
      Class.forName(driver);
      
      Connection con = DriverManager.getConnection(jdbcURL, id, pwd);// 예외 발생 구문
      if(con!=null) {
         System.out.println("connecting database");
         con.close(); // 예외 발생 구문
      }
      else {
         System.out.println("connectig fail");
      }
      
   }
}


