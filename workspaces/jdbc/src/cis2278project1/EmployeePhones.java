package cis2278project1;
//author: Katie Fedoseeva
//date: 2/7/17
//The purpose of this class is to manipulate the EmployeePhones table in the DB. 

public class EmployeePhones{
	private int emp_id;
	private String phone_number;

	public EmployeePhones () {
		emp_id = 0;
		phone_number = null;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "EmployeePhones [emp_id=" + emp_id + ", phone_number=" + phone_number + "]";
	}
	
	
}
