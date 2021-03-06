/*
 * DBProc.java
 *
 */

package com.ndnu.jdbc2;
import java.sql.*;
/**
 *
 * @author Rolly
 */
public class DBProc {
	private Connection conn;
	private Statement stmt;
    
    public DBProc() {
     	   DBConnection dbc = new DBConnection();
	   conn = dbc.getConnection();
	   try {
	     stmt = conn.createStatement();
	   }catch (SQLException sqlex) {
	     sqlex.printStackTrace();
	  }  
    }
   
	public void insertEmployee(int empId, String empFirstName,
				  String empLastName, String empHireDate, 
				  double empSalary, String empDeptId) {
	   String query = "insert into Employees values (" +
	   		  empId + " , '" + empFirstName + "', '" +
			  empLastName + "', '" +
			  empHireDate + "', " + 
			  empSalary + ", '" +  empDeptId + "')";
	 try {
	        stmt.executeUpdate(query);
	   }catch (SQLException e) {
	       e.printStackTrace();
	   } 
	}

	public void insertDepartment(String deptId, String deptName) {
	   String query = "insert into Departments values ('" +
		    	    deptId + "', '" + deptName + "')";
	   try {
	        stmt.executeUpdate(query);
	   }catch (SQLException e) {
	       e.printStackTrace();
	   }
	}

	public void deleteEmployee(int empId) {
	   String query = "delete from Employees where emp_id = " + empId;
	   try {
	        stmt.executeUpdate(query);
	   }catch (SQLException e) {
	       e.printStackTrace();
	   }
	}

	public void displayAllEmpsByDept() {
	   String query = "select emp_firstname, emp_lastname, dept_name " +
		      "from Employees, Departments " +
			  "where emp_deptid = dept_id " +
			  "order by dept_name ";
	   try {
	      ResultSet rs = stmt.executeQuery(query);
	      while (rs.next()) {
		  String empFirstName = rs.getString("emp_firstname");
		  String empLastName = rs.getString("emp_lastname");
		  String deptName = rs.getString("dept_name");

		  System.out.println(empFirstName + " " + empLastName +
				     "\t" + deptName);
	      }
	   }catch (SQLException e) {
	       e.printStackTrace();
	   }
	} 
	
	public void updateEmpSalary(int empId, int empSalary) {
		  
		  String query = "update Employees set emp_salary = " + empSalary + " where emp_id = " +
		    	    empId;
		  try {
		        stmt.executeUpdate(query);
		   }catch (SQLException e) {
		       e.printStackTrace();
		   }
	}
	
	public void displayDepartments() {
		   String query = "select emp_firstname, emp_lastname, dept_name " +
			          "from Employees, Departments " +
				  "where emp_deptid = dept_id " +
				  "order by dept_name ";
		   try {
		      ResultSet rs = stmt.executeQuery(query);
		      while (rs.next()) {
			  String empFirstName = rs.getString("emp_firstname");
			  String empLastName = rs.getString("emp_lastname");
			  String deptName = rs.getString("dept_name");

			  System.out.println(empFirstName + " " + empLastName +
					     "\t" + deptName);
		      }
		   }catch (SQLException e) {
		       e.printStackTrace();
		   }
	}
}

//Notes: to validate your SQL you can use DBSQL in terminal.
//when you're modifying (inserting, deleting, updating), using updateQuery
//exucuteQuery(query) when you retrieve information.
