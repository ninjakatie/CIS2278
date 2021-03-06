package cis2278project1;
//author: Katie Fedoseeva
//Date: 2/7/17
//Class Description: The Phone class provides methods that allow for manipulation... 
//...of the Phones table in the NDNUDB SQL database. 

public class Phone {
	private String ph_number;
	private String ph_model;
	
	public Phone(String ph_number, String ph_model) {
		this.ph_number = ph_number;
		this.ph_model = ph_model;
	}
	
	public Phone() {
		
	}
	
	public String getPh_number() {
		return ph_number;
	}

	public void setPh_number(String ph_number) {
		this.ph_number = ph_number;
	}

	public String getPh_model() {
		return ph_model;
	}

	public void setPh_model(String ph_model) {
		this.ph_model = ph_model;
	}

	public String toString() {
		return "Phones class: phone number =" + ph_number + "phone model = " + ph_model;
	}
}
