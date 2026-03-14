package student_course_system;

import java.io.Serializable;
import java.util.Set;

public class Course implements Serializable {

    private Integer id;
    private String courseName;
    private int credits;

    private Set<Student> students;

    public Course() {}

    public Course(Integer id, String courseName, int credits) {
        this.id = id;
        this.courseName = courseName;
        this.credits = credits;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}