package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Teacher {
    private String name;
    private List<Course> courses = new ArrayList<>();
    
    public Teacher(String name) {
        this.name = name;
    }

    public void addCourse(Course course) {
        courses.add(course); //adiciona um curso com um nome a esse professor, cada curso com tal nome tem uma lista de alunos.
    }

    public Set<Student> totalStudent() {
        Set<Student> total = new HashSet<>();

        for(Course course : courses)
            total.addAll(course.getStudents()); //cada estudante tem seu ID, hashSet de Student não permite iguais.
        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }
}