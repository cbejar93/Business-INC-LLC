package beans;

public class Employee {
	private int googleID;
	private int employeeID;
	private String firstName;
	private String lastName;
	private String email;
	public int getGoogleID() {
		return googleID;
	}
	public void setGoogleID(int googleID) {
		this.googleID = googleID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [googleID=" + googleID + ", employeeID=" + employeeID + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}

}
