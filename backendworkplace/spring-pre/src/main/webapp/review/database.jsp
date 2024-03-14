<%@page import="java.util.Arrays"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.mysql.cj.jdbc.result.ResultSetMetaData"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database</title>
<style>
	table {
		border: 1px solid black;
		border-collapse: collapse;
	}
	
	tr, td {
		border: 1px solid black;
		border-collapse: collapse;
		text-align: center;
	}
</style>
</head>
<body>
<%
	//Database에 연결하여 Connection이 만들어지는지 확인하는 코드 작성
	String id = "root";
	String pwd = "1234";
	String driver = "com.mysql.cj.jdbc.Driver";
	String jdbcURL = "jdbc:mysql://localhost:3306/sku";
	Class.forName(driver);
	Connection con = DriverManager.getConnection(jdbcURL,id,pwd);
	String sql = "select * from gisa limit 10;";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	ResultSetMetaData rsmd = (ResultSetMetaData)rs.getMetaData();
	int columnCount = rsmd.getColumnCount();
	System.out.println(columnCount);
	String[] columnNames = new String[columnCount];
	for(int i=0;i<columnCount;i++){
		columnNames[i] = rsmd.getColumnName(i+1);
	}
	String[][] values = new String[10][columnCount];
	//System.out.println(Arrays.toString(columnNames));
	
	int count = 0 ;
	while(rs.next()){
		for(int i=0;i<columnCount;i++){
			values[count][i] = rs.getString(i+1);
		}
		count = count + 1;
	}
	
	/* for(String[] value : values){
		System.out.println(Arrays.toString(value));
	} */
	rs.close();
	stmt.close();
	con.close();	
%>

<table>
	<tr>
		<td><%=columnNames[0] %></td><td><%=columnNames[1] %></td><td><%=columnNames[2] %></td><td><%=columnNames[3] %></td><td><%=columnNames[4] %></td>
		<td><%=columnNames[5] %></td><td><%=columnNames[6] %></td><td><%=columnNames[7] %></td><td><%=columnNames[8] %></td><td><%=columnNames[9]%></td><td><%=columnNames[10]%></td>
	</tr>
<%
	for(int i=0;i<values.length;i++){
		out.print("<tr>");
		for(int j=0;j<values[i].length;j++){
			
%>
		<td><%=values[i][j]%></td>
<%			
		}
		out.print("</tr>");
	}

%>
</table>
</body>
</html>







