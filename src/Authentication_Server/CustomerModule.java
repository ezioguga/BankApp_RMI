package Authentication_Server;

import java.util.ArrayList;

public class CustomerModule implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String FullNameWithEnitials, GoodName, Email, Address, Contact, Password, NIC, Gender;

	public CustomerModule() {
		
	}
	
	public CustomerModule(String fullNameWithEnitials, String goodName, String email, String address, String contact,
			String password, String nic, String gender) {
		super();
		FullNameWithEnitials = fullNameWithEnitials;
		GoodName = goodName;
		Email = email;
		Address = address;
		Contact = contact;
		Password = password;
		NIC = nic;
		Gender= gender;
	}

	public String getFullNameWithEnitials() {
		return FullNameWithEnitials;
	}

	public void setFullNameWithEnitials(String fullNameWithEnitials) {
		FullNameWithEnitials = fullNameWithEnitials;
	}

	public String getGoodName() {
		return GoodName;
	}

	public void setGoodName(String goodName) {
		GoodName = goodName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nic) {
		NIC = nic;
	}
	
	public String getGender()
	{
		return Gender;
	}
	
	public void setGender(String gender) {
		Gender= gender;
	}
	/*
	public int getPinNumberPatternGenerator() {
		// TODO Auto-generated method stub

		String gender = getGender();
		int pin= 0;
		
		int num = Integer.parseInt(getNIC().substring(5, 9));
		if(gender.compareToIgnoreCase("Male")==0) {
			if(num==000) {
				int num2 = Integer.parseInt(getNIC().substring(0, 2));
				int newNumber = (int) (Math.random()*100000) + num2;
				String val = (Integer.toString(newNumber)).substring(0,4);
				pin = Integer.parseInt(val);
			}else {
				pin=num*10;
			}
			
		}else {
			if(num<2000)
			{
				pin= num*5;
			}else {
				pin = (int) ((num/2)+ (Math.random()*1000));
			}
			
		}
		return pin;
	}*/

}
