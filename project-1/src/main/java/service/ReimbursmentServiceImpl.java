package service;

import java.util.List;

import beans.Reimbursment;
import dao.ReimbursmentDAO;
import dao.ReimbursmentDAOImpl;

public class ReimbursmentServiceImpl implements ReimbursmentService {

	private ReimbursmentDAO rd = new ReimbursmentDAOImpl();
	@Override
	public List<Reimbursment> ReimbursmentAll() {
		// TODO Auto-generated method stub
		return rd.ReimbursmentAll();
	}

	@Override
	public Reimbursment getReimbursmentByID(int id) {
		// TODO Auto-generated method stub
		return rd.getReimbursmentByID(id);
	}

	@Override
	public void createReimbursment(Reimbursment r) {
		// TODO Auto-generated method stub
		rd.createReimbursment(r);
		
	}

	@Override
	public void deleteReimbursment(int id) {
		// TODO Auto-generated method stub
		rd.deleteReimbursment(id);
		
	}

	@Override
	public void updateReimbursment(Reimbursment r) {
		// TODO Auto-generated method stub
		rd.updateReimbursment(r);
		
	}

	@Override
	public List<Reimbursment> getReimbursmentByEmployeeId(int eid) {
		// TODO Auto-generated method stub
		return rd.getReimbursmentByEmployeeId(eid);
	}

}
