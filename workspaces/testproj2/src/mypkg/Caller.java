package mypkg;

public class Caller {

	public static void main(String[] args) {
		//hn is the "reference" to the object. It contains the address of the object in the memory. 
		HelloNDNU hn = new HelloNDNU();
		hn.hello();
		int sum = hn.addNums(5, 10);
		System.out.println(sum);
		System.out.println(hn.name());
		Student student = new Student();
		student.setAge(26);
		student.setFirstName("Katie");
		System.out.println(student.getAge());
		System.out.println(student.getFirstName());
		Student student2 = new Student("Name", 20);
		System.out.println(student2.getFirstName());
		int ageDoubled = student.doubleAge(26);
		System.out.println(ageDoubled);
	}

}
