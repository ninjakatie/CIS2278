package mypkg;

public class Student {
	private String firstName;
	private int age;
	
	//constructors
	public Student(String fn, int age) {	
		firstName = fn;
		this.age = age;
	}
	public Student() {
	}
	
	//getters & setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int doubleAge(int age) {
		int ageDouble = age * 2;
		return ageDouble;
	}

}
