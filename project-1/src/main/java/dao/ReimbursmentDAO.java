package dao;

import java.util.List;

import beans.Employee;
import beans.Reimbursment;

public interface ReimbursmentDAO {

	public List<Reimbursment> ReimbursmentAll();
	public Employee getReimbursmentByID(int id);
	public void createReimbursment(Reimbursment r);
	public void deleteReimbursment(int id);
	public void updateReimbursment(Reimbursment r);
	
}
