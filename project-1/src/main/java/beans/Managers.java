package beans;

public class Managers {
	public Managers(int managerID, String title, int employeeID) {
		super();
		this.managerID = managerID;
		this.title = title;
		this.employeeID = employeeID;
	}
	private int managerID;
	private String title;
	private int employeeID;
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	@Override
	public String toString() {
		return "Managers [managerID=" + managerID + ", title=" + title + ", employeeID=" + employeeID + "]";
	}
}
