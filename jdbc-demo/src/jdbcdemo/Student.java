package jdbcdemo;

// This is POJO(Plain Old Java Object) class
public class Student {
	
	// attributes
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String course;
	
	// getter and setter pairs for each attribute
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}

	// optional method: to inspect
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", course=" + course + "]";
	}
	
}
