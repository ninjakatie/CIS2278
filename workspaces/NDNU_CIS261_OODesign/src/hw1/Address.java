package hw1;

public class Address {
	public String address;
	public String street;
	public String city;
	public String state;
	public int zip;
	
	public Address(String address, String street, String city, String state, int zip) {
		this.address = address;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public Address() {
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + ", street=" + street + ", city=" + city + ", state=" + state + ", zip="
				+ zip + "]";
	}
	
	
}


