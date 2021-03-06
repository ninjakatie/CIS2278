package hw1;
import java.util.*;

public class PersonDogDemo {

	public static void main(String[] args) {
		Calendar birthday = Calendar.getInstance();
		birthday.set(1990, 4, 2);
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		Dog bambi = new Dog();
		bambi.name = "Bambi";
		dogs.add(bambi);
		
	
		
		Address bambiAddress = new Address();
		bambiAddress.address = "3041 Kaiser Dr";
		
		Person person1 = new Person("Katie", "Fedoseeva", birthday.getTime(), dogs , bambiAddress);
		System.out.println(person1.getAge());
		
		System.out.println(person1.toString());
		person1.addDog("Bambi", "chihuahua", 2, 'F', 10, 1);
		System.out.println(dogs);

		Person person2 = new Person("Katie", "Bick", birthday.getTime(), dogs, bambiAddress);
		System.out.println(person2.equals(person1));
		
		Object clonedPerson = person1.clone();
		
		person1.getAddress().setCity("Belmont");
		System.out.println(person1);
		System.out.println(clonedPerson);
	}
}
