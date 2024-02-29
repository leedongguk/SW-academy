package sku.practice.database;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBCMain main = new JDBCMain();
		main.testCRUD();
	}
	
	public void testCRUD() {
		GisaDAO dao = new GisaDAO();
		try {
			//boolean flag = dao.insert(this.makeData());
				if(true) {
					String queryAnswer1 = "select std_no"
							+ " from gisa"
							+ " where loc_code = 'B'"
							+ " order by (kor+eng) desc, std_no asc"
							+ " limit 4,1";
					String queryAnswer2 = "select max(kor+eng) maxscore"
							+ " from gisa"
							+ " where loc_code = 'B'";
					String queryAnswer3 = "select sum(total)+sum(case"
							+ "	when acc_code='A' then 5"
							+ " when acc_code='B' then 15"
							+ " when acc_code='C' then 20"
							+ " end) point"
							+ " from gisa"
							+ " where (eng+math)>=120";
					StringBuilder sb = new StringBuilder("select count(*)");
					sb.append(" from");
					sb.append(" (select *	from gisa");
					sb.append("	where acc_code='A' or acc_code='B') A");
					sb.append(" where kor+(case");
					sb.append("	when loc_code='A' then 5");
					sb.append(" when loc_code='B' then 10");
					sb.append(" when loc_code='C' then 15");
					sb.append("	end)>=50");
					String queryAnswer4 = sb.toString();
					//로직클래스에게 데이터 전달
					try {
						String answer = dao.selectQuiz1(queryAnswer1);
						this.writeAnswer(1, answer);
						answer = dao.selectQuiz2(queryAnswer2);
						this.writeAnswer(2, answer);
						answer = dao.selectQuiz3(queryAnswer3);
						this.writeAnswer(3, answer);
						answer = dao.selectQuiz4(queryAnswer4);
						this.writeAnswer(4, answer);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ArrayList<Student> makeData(){
		ArrayList<Student> list = null;
		//file에 접속하여 생성
		File file = new File("Abc1115.csv");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			// 파일 안의 1000개의 라인에 각각 접근하여 --> 스트림 처리(IO)
			// 각 라인을 11개의 데이터로 분리하여 -->String 분리
			// Student객체로 생성한 다음 List에 저장 -->ArrayList
			list = new ArrayList<Student>();
			while((line=br.readLine())!=null) {
				String[] temp = line.split(",");
				int stdNo = Integer.parseInt(temp[0]);
				String email = temp[1];
				int kor = Integer.parseInt(temp[2].trim());
				int eng = Integer.parseInt(temp[3].trim());
				int math = Integer.parseInt(temp[4].trim());
				int sci = Integer.parseInt(temp[5].trim());
				int hist = Integer.parseInt(temp[6].trim());
				int total = Integer.parseInt(temp[7].trim());
				String mgrCode = temp[8];
				String accCode = temp[9];
				String locCode = temp[10];
				Student student = new Student(stdNo, email, kor, eng, math, sci, hist, total, mgrCode, accCode, locCode);
				list.add(student);
			}
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
		return list;
	}
	
	public void writeAnswer(int number,String answer) {
		System.out.println("정답을 받아서 답안지 작성");
		//파일 생성
		File file = new File("Ans"+number+".txt");
		//파일 접근
		try {
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(answer);
			pw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//파일 쓰기
		// --> 스트림 지식
	}

}
