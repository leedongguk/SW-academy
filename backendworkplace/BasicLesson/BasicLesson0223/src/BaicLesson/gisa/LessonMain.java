package BaicLesson.gisa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LessonMain {

	   public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      LessonMain lm = new LessonMain();
	      lm.startLesson();
	   }
	   // startLesson 메소드 이름으로 기본 메소드 생성
	   
	   public void startLesson() {
	      System.out.println("start Lesson");
	      this.testStart();
	   }
	   
	   // n개의 자료를 한번에 모아둬야함.-> data클래스를 정의해야한다 -> data클래스를 가지고
	   // 문제를 푸는 로직클래스를 만들어야한다.
	   
	   
	   public void testStart() {
	      //파일에있는 정보를 객체로 만드는 데이터 파일 생성
	      ArrayList<Student> list = this.makeData();
	      //객체에 있는 정보를 로직 클래스로 전달
	      Solution solution = new Solution();
	      String answer = solution.solveQuestion2(list);
	      //정답 받기
	      
	      

	      answer = solution.sloveQuestion1(this.makeData());
	      this.writeAnswer(1,answer);
	      answer = solution.solveQuestion2(this.makeData());
	      this.writeAnswer(2,answer);
	      answer = solution.sloveQuestion3(this.makeData());
	      this.writeAnswer(3,answer);
	      answer = solution.sloveQuestion4(this.makeData());
	      this.writeAnswer(4,answer);
	      
	      
	   }
	   
	   public ArrayList<Student> makeData(){
	      ArrayList<Student> list = null;
	      System.out.println("데이터를 생성해서 전달");
	      //파일 연결
	      //파일 안의 1000개의 라인에 각각 접근 -> 스트림 처리
	      // 파일 리더를 하나하나 읽기 위해서 bufferedreader라는 스트림 필요.
	      File file = new File("C:/Users/admin/Desktop/이동국자/Abc1115.csv");
	      
	      try {
	         FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr);
	         String line = null; // 한죽씩 읽어야함
	         list = new ArrayList<Student>(); // 데이터를 만드는 코드
	         while((line=br.readLine()) != null) {
	            String[] temp = line.split(","); // 1000개의 자료를 하나씩 읽어들임
	            // 숫자로 된 string형 자료들을 int형으로 바꿔주자.
	            int stdNo = Integer.parseInt(temp[0]);
	            String email = temp[1];
	            int kor = Integer.parseInt(temp[2].trim()); // 스트링안에 숫자가아닌 문자가 들어있는 띄어쓰기 처리 trim()
	            int eng = Integer.parseInt(temp[3].trim());
	            int math = Integer.parseInt(temp[4].trim());
	            int sci = Integer.parseInt(temp[5].trim());
	            int hist = Integer.parseInt(temp[6].trim());
	            int total = Integer.parseInt(temp[7].trim());
	            String mgrCode = temp[8];
	            String accCode = temp[9];
	            String localCode = temp[10];
	            Student student = new Student(stdNo, email, kor, eng, math, sci, hist, total, mgrCode, accCode, localCode);
	            list.add(student);
	            
	            // System.out.println(student);
	         }
	         
	         // String temp = line.substring(0,6);
	         //System.out.println(line);
	         //System.out.println(temp[0]);
	         br.close();
	         fr.close();
	         
	      } catch (FileNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (IOException ie) {
	         ie.printStackTrace();
	      }
	      

	      //각 라인을 11개의 데이터로 분리 -> String 분리 기술
	      //Student  객체로 생성한 다음 List에 저장 -> ArrayList 사용
	      return list;
	   }
	   
	   public void writeAnswer(int number ,String answer) {
	      System.out.println("답안작성");
	      //파일 생성
	      File file = new File("Ans"+number+".txt"); // Ans 뒤에 번호는 매번 바뀜.
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
	      //--> 스트림 지식
	   }
	}