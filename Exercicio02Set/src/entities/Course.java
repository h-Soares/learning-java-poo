package entities;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private char identifierChar;
    private Set<Student> students = new HashSet<>();

    public Course(char identifierChar) {
        this.identifierChar = identifierChar;
    }

    public void addStudent(Student student) { //adiciona aluno.
        students.add(student);
    }

    public char getIdentifierChar() {
        return identifierChar;
    }

    public void setIdentifierChar(char identifierChar) {
        this.identifierChar = identifierChar;
    }

    public Set<Student> getStudents() {
        return students;
    }
}