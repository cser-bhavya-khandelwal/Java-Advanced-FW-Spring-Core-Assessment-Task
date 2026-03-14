package university_management_system.spring.framework;

import java.io.Serializable;

public class StudentProfile implements Serializable{
	private Integer id;
	private String email;
	private long phone;
	public StudentProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentProfile(Integer id, String email, long phone) {
		super();
		this.id = id;
		this.email = email;
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "StudentProfile [id=" + id + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	

}
