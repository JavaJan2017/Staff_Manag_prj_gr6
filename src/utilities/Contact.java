package utilities;

public class Contact {
	
	private String adress;
	private String email;
	private String phone;
	
	//Constructor
	public Contact(String adr, String email, String phone) {
		this.adress = adr;
		this.email = email;
		this.phone = phone;
	}
	
	

	//Getters and Setters
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
