/*
 * DBTest.java
 *
 * Created on December 18, 2005, 9:39 AM
 *
 * Create this file under 'session2' package.
 */

package com.ndnu.jdbc2;

/**
 *
 * @author Rolly
 *
 * Follow instructions given in session1 to compile and run this program.
 */

//this class executes the statement.

public class DBTest {
    
    public static void main(String[] args) {
	   DBProc dbp = new DBProc();
	   dbp.insertEmployee(22, "King", "Kong", "2005-07-03", 215.35, "IT");
	   dbp.insertEmployee(23, "Jimmy", "Neutron", "2002-01-08", 161.35, "FIN");
	  // dbp.deleteEmployee(6);
	  // dbp.insertDepartment("ENG", "Engineering");
	   dbp.displayAllEmpsByDept();
//	   dbp.updateEmpSalary(23, 2000);
	   dbp.displayDepartments();
	}
}
