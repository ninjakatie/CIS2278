package cis2278project1;

import java.util.List;
import cis2278project1.EmpPhoneProcessor;
import cis2278project1.Employee;
import cis2278project1.Phone;

public class EmpPhoneTester {
	
	private static EmpPhoneProcessor proc = new EmpPhoneProcessor();
	
	private static void showPhones(int empId) {
		List<Phone> list = proc.getPhones(empId);
		for(Phone ph: list) {
			System.out.println(ph);
		}
		System.out.println("++++++++++++++++++++++++");
	}

	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setEmpId(333);
		emp.setEmpFirstName("Jim");
		emp.setEmpLastName("Shockey");
		emp.setEmpHireDate("2017-01-01");
		emp.setEmpSalary(1111.11);
		emp.setEmpDeptId("IT");

		Phone phone = new Phone("629-292-1234", "Motorola 3G");
		proc.createEmpPhone(emp, phone);
		
		Employee emp2 = new Employee();
		emp2.setEmpId(333);
		emp2.setEmpFirstName("Jim");
		emp2.setEmpLastName("Shockey");
		emp2.setEmpHireDate("2017-01-01");
		emp2.setEmpSalary(1111.11);
		emp2.setEmpDeptId("IT");

		Phone phone2 = new Phone();
		phone2.setPh_number("629-292-555");
		phone2.setPh_model("Motorola 6G");
		proc.createEmpPhone(emp2, phone2);
		
		showPhones(333);  
		
		proc.deleteEmpPhone(333, "629-292-1234");
		
		showPhones(333);
		
		Phone phone3 = new Phone("629-292-888", "Motorola 12G");
		proc.createEmpPhone(emp2, phone3);
		
		showPhones(333);
		
		proc.closeConnection();
	}

}