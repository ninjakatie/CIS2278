package cis2278project1;
public class Employee {

//Reusing Rolly's Employee class to save time. 	
	
	private int empId;
	private String empFirstName;
	private String empLastName;
	private double empSalary;
	private String empHireDate;
	private String empDeptId;

	public Employee(String empId, String empFirstName, String empLastName, double empSalary, String empHireDate, String empDeptId) {
	   this.empId = -1;
	   this.empFirstName = null;
	   this.empLastName = null;
	   this.empSalary = 0.0;
	   this.empHireDate = null;
	   this.empDeptId = null;
	}
	
	public Employee() {
		this.empId = -1;
		   this.empFirstName = null;
		   this.empLastName = null;
		   this.empSalary = 0.0;
		   this.empHireDate = null;
		   this.empDeptId = null;
	}

	public void setEmpId(int id) {
	   empId = id;
	}

	public void setEmpFirstName(String fn) {
	   empFirstName = fn;
	}

	public void setEmpLastName(String ln) {
	   empLastName = ln;
	}

	public void setEmpSalary(double sal) {
	   empSalary = sal;
	}

	public void setEmpHireDate(String date) {
	   empHireDate = date;
	}

	public void setEmpDeptId(String id) {
	   empDeptId = id;
	}

	public int getEmpId() {
	   return empId;
	}

	public String getEmpFirstName() {
	   return empFirstName;
	}

	public String getEmpLastName() {
	   return empLastName;
	}

	public double getEmpSalary() {
	   return empSalary;
	}

	public String getEmpHireDate() {
	   return empHireDate;
	}

	public String getEmpDeptId() {
	   return empDeptId;
	}

	public String toString() {
	   String retVal = "EmpId: " + empId + "\n" +
	   		   "EmpFirstName: " + empFirstName + "\n" +
	   		   "EmpLastName: " + empLastName + "\n" +
	   		   "EmpSalary: " + empSalary + "\n" +
	   		   "EmpHireDate: " + empHireDate + "\n" +
	   		   "EmpDeptId: " + empDeptId + "\n";
	   return retVal;
	}
}