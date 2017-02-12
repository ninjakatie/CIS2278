package mypkg;

public class HelloNDNU {

	public static void main(String[] args) {
	 HelloNDNU hn = new HelloNDNU();
	 hn.hello();
	}
	
	public void hello() {
		System.out.println("hello NDNU");
	}
	
	public int addNums(int a, int b) {
		return a + b;
	}
	
	public String name() {
		String myName = "Katie";
		return myName;
	}

}
