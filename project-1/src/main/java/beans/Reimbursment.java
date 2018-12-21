package beans;

public class Reimbursment {
	
	public Reimbursment(int rID, String description, int amount, int pictureID, int employeeID, String resolved,
			String date, String whoResolved) {
		super();
		this.rID = rID;
		this.description = description;
		this.amount = amount;
		this.pictureID = pictureID;
		this.employeeID = employeeID;
		this.resolved = resolved;
		this.date = date;
		this.whoResolved = whoResolved;
	}
	
	public Reimbursment(String description, int amount, int pictureID, int employeeID, String resolved,
			String date, String whoResolved) {
		this.description = description;
		this.amount = amount;
		this.pictureID = pictureID;
		this.employeeID = employeeID;
		this.resolved = resolved;
		this.date = date;
		this.whoResolved = whoResolved;
	}
	private int rID;
	private String description;
	private int amount;
	private int pictureID;
	private int employeeID;
	private String resolved;
	private String date;
	private String whoResolved;
	public int getrID() {
		return rID;
	}
	public void setrID(int rID) {
		this.rID = rID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPictureID() {
		return pictureID;
	}
	public void setPictureID(int pictureID) {
		this.pictureID = pictureID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getResolved() {
		return resolved;
	}
	public void setResolved(String resolved) {
		this.resolved = resolved;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWhoResolved() {
		return whoResolved;
	}
	public void setWhoResolved(String whoResolved) {
		this.whoResolved = whoResolved;
	}
	@Override
	public String toString() {
		return "Reimbursment [rID=" + rID + ", description=" + description + ", amount=" + amount + ", pictureID="
				+ pictureID + ", employeeID=" + employeeID + ", resolved=" + resolved + ", date=" + date
				+ ", whoResolved=" + whoResolved + "]";
	}

}
