package service;

import java.util.List;

import beans.Reimbursment;


public interface ReimbursmentService {

	
	public List<Reimbursment> ReimbursmentAll();

	public Reimbursment getReimbursmentByID(int id);

	public void createReimbursment(Reimbursment r);

	public void deleteReimbursment(int id);

	public void updateReimbursment(Reimbursment r);
	
	public List<Reimbursment> getReimbursmentByEmployeeId(int eid);
	
}
