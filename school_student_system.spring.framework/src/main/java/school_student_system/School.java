package school_student_system;

import java.io.Serializable;
import java.util.List;

public class School implements Serializable {

    private Integer id;
    private String name;
    private String city;

    private List<Student> students;

    public School() {}

    public School(Integer id, String name, String city, List<Student> students) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}