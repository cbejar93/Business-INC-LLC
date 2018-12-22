package beans;

public class Manager_Emplyee {

	public Manager_Emplyee(int employeeID, int managerID) {
		super();
		this.employeeID = employeeID;
		this.managerID = managerID;
	}

	private int employeeID;
	private int managerID;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	@Override
	public String toString() {
		return "Manager_Emplyee [employeeID=" + employeeID + ", managerID=" + managerID + "]";
	}

}
