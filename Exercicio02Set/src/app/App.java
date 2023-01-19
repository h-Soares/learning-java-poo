package app;

import java.util.Scanner;
import entities.Course;
import entities.Student;
import entities.Teacher;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Teacher name: ");
        String teacherName = scan.nextLine();
        Teacher teacher = new Teacher(teacherName);

        openCourses(teacher);

        for(Course course : teacher.getCourses()) {
            System.out.print("Number of students of course " + course.getIdentifierChar() + ": ");
            int studentsNumbes = scan.nextInt();

            for(int i = 1; i <= studentsNumbes; i++) {
                int studentId = scan.nextInt();
                course.addStudent(new Student(studentId));
            }
        }

        System.out.println("Total students: " + teacher.totalStudent().size());

        scan.close();
    }
    static void openCourses(Teacher teacher) {
        for(char identifierChar = 'A'; identifierChar <= 'C'; identifierChar++)
            teacher.addCourse(new Course(identifierChar));
    }
}