package Transaction_Server;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface TransactionInterface extends Remote{
	/*  GROUP 2 - UoB Feb 2020
	 *  Dasuni Uthpala  		- 1940797 - Validation Control Server
	 *  Gugatharsan Sivalingam  - 1941258 - Client Side
	 *  Ramsunthar Sivasankar   - 1940933 - Transaction COntrol Server
	 */
	
	/*this will hold the card details for the transaction*/
	public void addCard(int cardNumber,int pin) throws  RemoteException;
	
	/*to display the amount that the user holds in his/her account*/
	public void displayBalance() throws RemoteException;
	
	/*to transfer amount to another remote account*/
	public String transferAmount(int accountNumber,float amount, int pin) throws RemoteException;

	/*Utility Payments section*/
	
	/*to pay the phone bill*/
	public String payPhoneBill(int number,String NIC,int phoneNo,float amount) throws RemoteException;
	
	/*to pay the water bill*/
	public String payWaterBill(int number,String NIC,int phoneNo,float amount) throws RemoteException;

	/*to pay the electricity bill*/
	public String payElectricityBill(int number,String NIC,int phoneNo,float amount) throws RemoteException;

	/*Generate Report for the utility payments*/
	public void printReport() throws RemoteException;
}
