package com.ndnu.jdbc3;
public class DBTest {
	public static void main(String[] args) {
	   DBProc dbp = new DBProc();
	   dbp.insertDepartment("TRA", "Training");
	   Employee e = dbp.getEmployee(3);
	   System.out.println(e);
	   e = dbp.getEmployee(1);
	   System.out.println(e);
	   Department d = dbp.getDepartment("IT");
	   System.out.println(d);
	   d = dbp.getDepartment("TRA");
	   System.out.println(d);
           dbp.closeConnection();
	}
}
