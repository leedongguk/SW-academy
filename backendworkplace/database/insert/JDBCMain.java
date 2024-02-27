package sku.lesson.db.try1;

import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBCMain main = new JDBCMain();
		main.testCRUD();
	}
	
	public void testCRUD() {
		String sql = "insert into gisa values (990002,'addx',17,29,16,49,43,154,'C','A','C')";
		GisaDAO dao = new GisaDAO();
		try {
			//boolean flag = dao.insert(sql);
			//sql = "delete from gisa where std_no = ?";
			//boolean flag = dao.delete(sql);
			//Student student = new Student(990003,"addx",17,29,16,49,43,154,"C","A","C");
			//boolean flag = dao.insert(student);
			boolean flag = dao.insert(this.makeData());
			if(flag) {
				System.out.println("insert success");
			} else {
				System.out.println("insert fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ArrayList<Student> makeData(){
		ArrayList<Student> list = null;
		//file에 접속하여 생성
		return list;
	}

}
