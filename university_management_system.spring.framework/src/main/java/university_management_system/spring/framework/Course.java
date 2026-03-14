package university_management_system.spring.framework;

import java.io.Serializable;

public class Course implements Serializable{
	private Integer id;
	private String courseName;
	private Integer credits;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(Integer id, String courseName, Integer credits) {
		super();
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

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", credits=" + credits + "]";
	}
	
	

}
