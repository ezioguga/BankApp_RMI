package Transaction_Server;

//Name: Ramsutnhar Sivasankar
//ID number: 1940933
	//Group ID: 02

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

//import javax.mail.*;
//import javax.mail.internet.*;


public class TransactionImplement extends UnicastRemoteObject implements TransactionInterface{
	
	
	Scanner s = new Scanner(System.in);
	
	TransactionModule module = new TransactionModule();

	protected TransactionImplement() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void addCard(int cardNumber, int pin) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Enter the Card Number :");
		cardNumber = s.nextInt();
		System.out.println("Enter the pin Number :");
		pin = s.nextInt();
		 
		
		
	}

	@Override
	public void displayBalance() throws RemoteException {
		
		System.out.println("Your Balance is : "+ module.getBalance());
		
	}

	@Override
	public String transferAmount(int accountNumber, float amount, int pin)
			throws RemoteException {
		float balance = module.getBalance();
		System.out.println("Enter the account number :");
		module.setAccountNumber(accountNumber);
		System.out.println("Enter the amount :");
		module.setAmount(amount);
		System.out.println("Enter the pin number :");
		module.setAmount(pin);
		if( amount > balance) { 
			return "you don't sufficient amount in your account";
		}
		else {
			return "Transaction Successful";
		}
	}

	@Override
	public String payPhoneBill(int number, String NIC, int phoneNo, float amount)
			throws RemoteException {
		float balance = module.getBalance();
		System.out.println("Enter the account number :");
		module.setAccountNumber(number);
		System.out.println("Enter the NIC number :");
		module.setNIC(NIC);
		System.out.println("Enter the phone number :");
		module.setPhoneNumber(phoneNo);
		System.out.println("Enter the amount :");
		module.setAmount(amount);
		if( amount > balance) { 
			return "you don't sufficient amount in your account";
		}
		else {
			return "Transaction Successful";
		}
	}

	@Override
	public String payWaterBill(int number, String NIC, int phoneNo, float amount)
			throws RemoteException {
		float balance = module.getBalance();
		System.out.println("Enter the account number :");
		module.setAccountNumber(number);
		System.out.println("Enter the NIC number :");
		module.setNIC(NIC);
		System.out.println("Enter the phone number :");
		module.setPhoneNumber(phoneNo);
		System.out.println("Enter the amount :");
		module.setAmount(amount);
		if( amount > balance) { 
			return "you don't sufficient amount in your account";
		}
		else {
			return "Transaction Successful";
		}
	}

	@Override
	public String payElectricityBill(int number, String NIC, int phoneNo,
			float amount) throws RemoteException {
		float balance = module.getBalance();
		System.out.println("Enter the account number :");
		module.setAccountNumber(number);
		System.out.println("Enter the NIC number :");
		module.setNIC(NIC);
		System.out.println("Enter the phone number :");
		module.setPhoneNumber(phoneNo);
		System.out.println("Enter the amount :");
		module.setAmount(amount);
		if( amount > balance) { 
			return "you don't sufficient amount in your account";
		}
		else {
			return "Transaction Successful";
		}
	}

	@Override
	public void printReport() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void printReport() throws RemoteException {
//		// TODO Auto-generated method stub
//		
//	}

	
	/**
	 * 
	 */
	

}
