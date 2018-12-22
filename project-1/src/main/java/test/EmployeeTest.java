package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;

public class EmployeeTest {

	private static EmployeeDAO ed;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ed = new EmployeeDAOImpl();
	}

	@Test
	public void testEmployeeAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployeeByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateEmployee() {
		fail("Not yet implemented");
	}

}
