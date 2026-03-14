package university_management_system.spring.framework;

import java.io.Serializable;
import java.util.List;

public class Department implements Serializable {

	private Integer id;
	private String name;

	// 1:M
	private List<Course> courses;

	public Department() {
		super();
	}

	public Department(Integer id, String name) {
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}