package program;


//테이블 담당 클래스 (DataBase Access Object)
//java와 db는 네트워크 관계. 즉 외부에 데이터가 있음
//외부에 있는 데이터와 연결하기 위해선 stream이 필요
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.sql.ResultSetMetaData;

	public class BookDAO {
	   
	   public void input(String sql) {
	      System.out.println(sql);
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      
	      try {
	         con = ConnectionManager.getConnection();
	         stmt = con.createStatement();
	         rs = stmt.executeQuery(sql);
	         String output = "";
	         if (rs != null && rs.next()) {
	            ResultSetMetaData rsmd = rs.getMetaData();
	            int columnCount = rsmd.getColumnCount();

	               for (int i = 1; i <= columnCount; i++) {
		               
	            	   String s = rsmd.getColumnName(i);
	            	   output += s+ " ";
	            	   
	            	   
	               }
	               System.out.println(output);
	            while(rs.next()) {
	               //행처리
	               output = "";
	               
	               
	               
	               for (int i = 1; i <= columnCount; i++) {
	                   String value = rs.getString(i);
	                   
	                   if (value != null) {
	                	   
	                	   
	                       output += value;
	                   }
	               }
	               
	               System.out.println(output);
	            }
	         } else {
	            System.out.println("ResultSet is empty or null");
	         }
	         
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         ConnectionManager.closeConnection(rs, stmt, con);
	      }
	   }
	}

  /* public void select(String sql) {
      Connection con = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      try {
         con = ConnectionManager.getConnection();
         stmt = con.createStatement();
         rs = stmt.executeQuery(sql);
        System.out.println(rs); 
        
         while(rs.next()) {
            //행처리
        	String attr0=rs.getString(0);
            String attr1=rs.getString(1);
            String attr2=rs.getString(2);
            String attr3=rs.getString(3);
            int attr4=rs.getInt(4);
            //int attr4=rs.getInt("price");
            System.out.println(attr0 + ","+ attr1+","+attr2+","+attr3+","+(attr4*10));
         }
         
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      ConnectionManager.closeConnection(rs, stmt, con);
      
   }*/
   /*
   public void input(String sql) {
	   
	      System.out.println(sql);
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      
	      try {
	         con = ConnectionManager.getConnection();
	         stmt = con.createStatement();
	         rs = stmt.executeQuery(sql);
	         while(rs.next()) {
	            //행처리
	            String output = "";
	            
	            if(rs.getString(1) != null) {
		            output += rs.getString(1);	
	            }
	            if(rs.getString(2) != null) {
		            output += rs.getString(2);	
	            }
	            if(rs.getString(3) != null) {
		            output += rs.getString(3);	
	            }
	            if(rs.getString(4) != null) {
		            output += rs.getString(4);	
	            }
	            
	            System.out.println(output);
	         }
	         
	      } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      ConnectionManager.closeConnection(rs, stmt, con);
	   
   }
}*/