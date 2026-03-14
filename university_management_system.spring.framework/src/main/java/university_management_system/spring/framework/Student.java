package university_management_system.spring.framework;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable{

	private Integer id;
	private String name;

	// 1:1
	private StudentProfile profile;

	// M:1
	private Department department;

	// M:M
	private Set<Course> courses;

	public Student() {
		super();
	}

	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public StudentProfile getProfile() {
		return profile;
	}

	public void setProfile(StudentProfile profile) {
		this.profile = profile;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}