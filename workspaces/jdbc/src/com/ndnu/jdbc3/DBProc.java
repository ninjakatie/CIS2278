package com.ndnu.jdbc3;
import java.sql.*;

public class DBProc {
//'Proc' stands for procedures. Where we store all the query methods. 
	
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
        
        public void closeConnection() {
            try {
                conn.close();
            }catch (SQLException sqlex){
                sqlex.printStackTrace();
            }
        }

	public void insertEmployee(int empId, String empFirstName,
				  String empLastName, double empSalary,
				  String empHireDate, String empDeptId) {
	   String query = "insert into Employees values (" +
	   		  empId + " , '" + empFirstName + "', '" +
			  empLastName + "', '" + empHireDate + "', " +
			  empSalary + ", '" + empDeptId + "')";
	   try {
	        stmt.executeUpdate(query);
	   }catch (SQLException e) {
	       e.printStackTrace();
	   }
	}

	// Notice the use of PreparedStatement in contrast to the
	// insertEmployee() method.
	
	public void insertDepartment(String deptId, String deptName) {
	   String query = "insert into Departments values (?, ?)";
	   try {
		PreparedStatement prepStmt = conn.prepareStatement(query);
		prepStmt.setString(1, deptId);
		prepStmt.setString(2, deptName);
	        prepStmt.executeUpdate();
	   }catch (SQLException e) {
	       e.printStackTrace();
	   }
	}

	public void deleteEmployee(int empId) {
	   String query = "delete from Employees where emp_id = ?";
	   try {
		PreparedStatement prepStmt = conn.prepareStatement(query);
		prepStmt.setInt(1, empId);
	        prepStmt.executeUpdate();
	   }catch (SQLException e) {
	       e.printStackTrace();
	   }
	}

	public Employee getEmployee(int id) {
	   Employee emp = new Employee();
	   String query = "select emp_id, emp_firstname, emp_lastname, " +
		   	  "emp_salary, emp_hiredate, emp_deptid " +
		          "from Employees " +
		   	  "where emp_id = ?";
	   try {
		PreparedStatement prepStmt = conn.prepareStatement(query);
		prepStmt.setInt(1, id);
	        ResultSet rs = prepStmt.executeQuery();
	        while (rs.next()) {
		  // I will use column names to pass to the getXXX methods
		  int empId = rs.getInt("emp_id");
		  String empFirstName = rs.getString("emp_firstname"); //this is the recommended way because it describes exactly which column is referenced. 
		  String empLastName = rs.getString("emp_lastname");
		  double empSalary = rs.getDouble("emp_salary");
		  String empHireDate = rs.getString("emp_hiredate");
		  String empDeptId = rs.getString("emp_deptid");

		  emp.setEmpId(empId);
		  emp.setEmpFirstName(empFirstName);
		  emp.setEmpLastName(empLastName);
		  emp.setEmpSalary(empSalary);
		  emp.setEmpHireDate(empHireDate);
		  emp.setEmpDeptId(empDeptId);
		}
	   }catch (SQLException e) {
	       e.printStackTrace();
	   }

	   return emp;
	}

	public Department getDepartment(String id) {
	   Department dept = new Department();
	   String query = "select dept_id, dept_name " +
		          "from Departments " +
		   	  "where dept_id = ?";
	   try {
		PreparedStatement prepStmt = conn.prepareStatement(query);
		prepStmt.setString(1, id);
	        ResultSet rs = prepStmt.executeQuery();
	        while (rs.next()) {
		  //Instead of table column names, I will pass numbers
		  //to the getXXX methods.
		   String deptId = rs.getString(1);
		   String deptName = rs.getString(2);
		   dept.setDeptId(deptId);
		   dept.setDeptName(deptName);
		}
	   }catch (SQLException e) {
	       e.printStackTrace();
	   }

	   return dept;
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
}
