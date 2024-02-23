package BaicLesson.gisa;

/*import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;





public class Solution {
	

	public String solveQuestion1(ArrayList<Student> data) {
		// TODO Auto-generated method stub
		List<Student> areaBStudents = new ArrayList<>();
		for(Student student : data) {
            if (student.getAccCode().equals("B")) {
                areaBStudents.add(student);
            }
		}
		
        Collections.sort(areaBStudents, Comparator.comparingInt(Student::getTotal).reversed()
                .thenComparing(Student::getStdNo));
        
        int StdNo = areaBStudents.get(4).getStdNo();
        answer = String.valueOf(stdNo);
		
        if (areaBStudents.size() >= 5) {
            return String.valueOf(areaBStudents.get(4).getStdNo());
        } else {
            return "B없음요.";
        }
	}

	public String solveQuestion2(ArrayList<Student> list) {
		
		String answer = null;
		int max = 0;
		
		for(Student st : list) {
			if(st.getLocCode().equals("B")) {
				if(max<(st.getKor() + st.getEng())) {
					max = st.getKor() + st.getEng();
				}
			}
		}
		
		System.out.println("문제풀이");
		answer = String.valueOf(max);
		return answer;
	}
	
	public String solveQuestion3(ArrayList<Student> data) {
		
		int sum = 0;
		for(Student student : data) {
			int point = 0;
			if(student.getEng()+student.getMath()>=120) {
			if(student.getAccCode().equals("A")) {
				point = 5;
			} else if(student.getAccCode().equals("B")) {
				point = 15;
			} else if(student.getAccCode().equals("C")) {
				point = 20;
			}
			
			
				sum = sum + student.getTotal() + point;
			}
		}
		// TODO Auto-generated method stub
		return String.valueOf(sum);
	}

	public String solveQuestion4(ArrayList<Student> data) {
		// TODO Auto-generated method stub
        int count = 0;
        for (Student student : data) {
            if (student.getLocCode().charAt(0) == 'A' || student.getLocCode().charAt(0) == 'B') {
                if (student.getKor() + getPointsForArea(student) >= 50) {
                    count++;
                }
            }
        }
        return String.valueOf(count);
	}
    public static int getPointsForArea(Student student) {
        int points = 0;
        switch (student.getLocCode().charAt(0)) {
            case 'A':
                points = 5;
                break;
            case 'B':
                points = 3;
                break;
            case 'C':
                points = 2;
                break;
        }
        return points;
    }
	

}*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

   public String solveQuestion2(ArrayList<Student> list) {
      String answer = null;
      // 지역 코드가 B인 자료에 대하여 (국어점수 + 영어점수) 중 가장 큰 값 구하기
      // ArrayList 지식
      // max 알고리즘
      // 기본 문법 (변수, 제어문)
      // 객체의 기본 사용법
      int max = 0;
      for (Student st : list) {
         if (st.getLocCode().equals("B")) {
            if (max < st.getKor() + st.getEng()) {
               max = st.getKor() + st.getEng();
            }
         }
      }
      System.out.println("문제 풀이");
      answer = String.valueOf(max);
      return answer;
   }

   public String sloveQuestion3(ArrayList<Student> data) {
      // TODO Auto-generated method stub
      int sum = 0;
      int count = 0;
      for (Student student : data) {
         int point = 0;
         if (student.getEng() + student.getMath() >= 120) {
            if (student.getAccCode().equals("A")) {
               point = 5;
            } else if (student.getAccCode().equals("B")) {
               point = 15;
            } else if (student.getAccCode().equals("C")) {
               point = 20;
            }
            count++;
            sum += student.getTotal() + point;
         }
      }
      System.out.println(count);
      return String.valueOf(sum);
   }

   public String sloveQuestion4(ArrayList<Student> data) {
      int cnt=0;
      int point=0;
      for(Student st:data) {
         if(st.getAccCode().equals("A") || st.getAccCode().equals("B")) {
            if(st.getLocCode().equals("A")) {
               point=5;
            }else if(st.getLocCode().equals("B")) {
               point=10;
            }else if(st.getLocCode().equals("C")) {
               point=15;
            }
            
            if(st.getKor()+point>=50) {
               cnt++;
            }
         }
      }
      return String.valueOf(cnt);
      
   }

   public String sloveQuestion1(ArrayList<Student> data) {
      String answer=null;
      ArrayList<Student> quiz4 =new ArrayList<>();
      for(Student st:data) {
         if(st.getLocCode().equals("B")) {
            quiz4.add(st);
         }
      }
      
      Collections.sort(quiz4,new GisaComparator());
      this.printQuiz(quiz4, 0, 5);
      int stdNo=quiz4.get(4).getStdNo();
      answer=String.valueOf(stdNo);
      
      return answer;
      
   }
   
   public void printQuiz(ArrayList<Student> quiz, int start, int end) {
      for(int i=start; i<end; i++) {
         System.out.println(quiz.get(i));
      }
   }

}
