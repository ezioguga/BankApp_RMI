package Transaction_Server;

import java.util.ArrayList;

public class TransactionModule  implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int CardNumber,PIN,AccountNumber,Number,PhoneNumber;
	private String NIC;
	private float amount,balance;
	
	public TransactionModule() {
		
	}
	
	public TransactionModule(String NIC,float amount,int cardNumber,int pin,float balance,int accountNumber, int number,int phoneNo){
		super();
		this.NIC = NIC;
		this.amount = amount;
		CardNumber = cardNumber;
		PIN = pin;
		AccountNumber = accountNumber;
		Number = number;
		PhoneNumber = phoneNo;
		this.balance = balance;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(int cardNumber) {
		CardNumber = cardNumber;
	}

	public int getPIN() {
		return PIN;
	}

	public void setPIN(int pIN) {
		PIN = pIN;
	}

	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public int getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
	
}
