package dongguk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    String studentID;
    int koreanScore;
    int englishScore;
    char areaCode;

    public Student(String studentID, int koreanScore, int englishScore, char areaCode) {
        this.studentID = studentID;
        this.koreanScore = koreanScore;
        this.englishScore = englishScore;
        this.areaCode = areaCode;
    }

    public int getTotalScore() {
        return koreanScore + englishScore;
    }

    public char getAreaCode() {
        return areaCode;
    }

    public String getStudentID() {
        return studentID;
    }
}

public class Main {
    public static void main(String[] args) {
        String filePath = "C:/Users/admin/Desktop/이동국자/Abc1115.csv";
        String ans1FilePath = "C:/Users/admin/Desktop/이동국자/Ans1.txt";
        String ans2FilePath = "C:/Users/admin/Desktop/이동국자/Ans2.txt";
        String ans3FilePath = "C:/Users/admin/Desktop/이동국자/Ans3.txt";
        String ans4FilePath = "C:/Users/admin/Desktop/이동국자/Ans4.txt";

        List<Student> students = readDataFromFile(filePath);

        // 문제 1
        String fifthStudentID = getFifthStudentIDWithAreaCodeB(students);
        writeResultToFile(ans1FilePath, fifthStudentID);

        // 문제 2
        int maxTotalScore = getMaxTotalScoreWithAreaCodeB(students);
        writeResultToFile(ans2FilePath, String.valueOf(maxTotalScore));

        // 문제 3
        int sumTotalScoreWithPoints = getSumTotalScoreWithPoints(students);
        writeResultToFile(ans3FilePath, String.valueOf(sumTotalScoreWithPoints));

        // 문제 4
        int countStudentsWithAreaCodeABOver50 = countStudentsWithAreaCodeABOver50(students);
        writeResultToFile(ans4FilePath, String.valueOf(countStudentsWithAreaCodeABOver50));
    }

    public static List<Student> readDataFromFile(String filePath) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String studentID = parts[0];
                int koreanScore = Integer.parseInt(parts[2]);
                int englishScore = Integer.parseInt(parts[4]);
                char areaCode = parts[10].charAt(0);

                students.add(new Student(studentID, koreanScore, englishScore, areaCode));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return students;
    }

    public static String getFifthStudentIDWithAreaCodeB(List<Student> students) {
        List<Student> areaBStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getAreaCode() == 'B') {
                areaBStudents.add(student);
            }
        }

        Collections.sort(areaBStudents, Comparator.comparingInt(Student::getTotalScore).reversed()
                .thenComparing(Student::getStudentID));

        if (areaBStudents.size() >= 5) {
            return areaBStudents.get(4).getStudentID();
        } else {
            return "B없음요.";
        }
    }

    public static int getMaxTotalScoreWithAreaCodeB(List<Student> students) {
        int maxTotalScore = Integer.MIN_VALUE;
        for (Student student : students) {
            if (student.getAreaCode() == 'B') {
                maxTotalScore = Math.max(maxTotalScore, student.getTotalScore());
            }
        }
        return maxTotalScore;
    }

    public static int getSumTotalScoreWithPoints(List<Student> students) {
        int sumTotalScoreWithPoints = 0;
        for (Student student : students) {
            if (student.getTotalScore() + getPointsForAchievement(student) >= 120) {
                sumTotalScoreWithPoints += (student.getTotalScore() + getPointsForAchievement(student));
            }
        }
        return sumTotalScoreWithPoints;
    }

    public static int countStudentsWithAreaCodeABOver50(List<Student> students) {
        int count = 0;
        for (Student student : students) {
            if (student.getAreaCode() == 'A' || student.getAreaCode() == 'B') {
                if (student.koreanScore + getPointsForArea(student) >= 50) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int getPointsForAchievement(Student student) {
        int points = 0;
        switch (student.areaCode) {
            case 'A':
                points = 10;
                break;
            case 'B':
                points = 8;
                break;
            case 'C':
                points = 6;
                break;
        }
        return points;
    }

    public static int getPointsForArea(Student student) {
        int points = 0;
        switch (student.areaCode) {
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

    public static void writeResultToFile(String filePath, String result) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}