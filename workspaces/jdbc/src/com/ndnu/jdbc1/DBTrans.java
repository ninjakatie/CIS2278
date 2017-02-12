
package com.ndnu.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * DBTrans.java
 *
 *
 * Here's how to run this class manually (of course, mysqld must be running):
 * java -classpath .;<dir path>\mysql-conn.jar DBTrans
 */
 

/**
 *
 * @author Rolly
 */

public class DBTrans {
    
  	private Connection dbconn;
	private Statement stmt;


	public DBTrans() {

	// This resource locator line will be used when running this
	// program in the same machine as the Derby dbserver is running.
	  String url = "jdbc:derby://localhost:1527/NDNUDB";

	
	  try {
	// Following line creates an instance of the JDBC driver.
	     Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
	
	//Establishing database connection.
	     dbconn = DriverManager.getConnection(url, "guest", "password");


	//Creating a Statement object - used to submit SQL queries.
	     stmt = dbconn.createStatement();

	  }catch (ClassNotFoundException e) {
	     e.printStackTrace();
	  }catch (SQLException sqlex) {
	     sqlex.printStackTrace();
	  }catch (Exception ex) {
	     ex.printStackTrace();
	  }
	}

	public void displayTableRows() {
	    int empId = 0;
	    String empFirstName = null;
	    String empLastName = null;
	    double empSalary = 0.0;
	    // Do not confuse with java.util.Date
	    java.sql.Date empHireDate = null;
	    String empDeptId = null;

	    String sql = "select emp_id, emp_firstname, " +
		         "emp_lastname, emp_salary, " +
			 "emp_hiredate, emp_deptid " +
			 "from Employees ";
	    ResultSet rs = null; 

	     try {
	// Execute the SQL query. Results will be in ResultSet object.
	        rs = stmt.executeQuery(sql);

	// Iterate through the result set, retrieve values and display.
	  	while(rs.next()) {
		  empId = rs.getInt(1);
		  empFirstName = rs.getString(2);
		  empLastName = rs.getString(3);
		  empSalary = rs.getDouble(4);
		  empHireDate = rs.getDate(5);
		  empDeptId = rs.getString(6);

		  System.out.println(empId + "\t" + empFirstName + "\t" +
		  		empLastName + "\t" + empSalary + "\t" +
				empHireDate + "\t" + empDeptId);
		}
	     }catch (SQLException e) {
	       e.printStackTrace();
	     }catch (Exception ex) {
	        ex.printStackTrace();
	     }finally {
		  try {
		     rs.close();
		     stmt.close();
		     dbconn.close();
	           }catch (SQLException e) {
	               e.printStackTrace();
		   }
	     }

	}

	public void closeConnection() {
		try {
			dbconn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void selectEmployee(int empId) {
		 if (empId == 2) {
			 String sql = "select emp_id, emp_firstname, " +
			         "emp_lastname, emp_salary, " +
				 "emp_hiredate, emp_deptid " +
				 "from Employees ";
		 }
	}
    
}
// you create a connection object so you can create a statement object and then.. 
// ...send an SQL query, then you get a result. 

