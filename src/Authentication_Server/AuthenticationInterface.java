package Authentication_Server;

import java.rmi.*;
import java.util.*;

public interface AuthenticationInterface extends Remote {

	public String register(String fullNameWithEnitials, String goodName, String email, String password, String nic,
			String gender) throws RemoteException;

	public String Login(String Username, String Pass) throws RemoteException;

	public int PinNumberPatternGenerator() throws RemoteException;

	public void EmailSender(int pin) throws RemoteException;

	public String Logout(String cookie) throws RemoteException;

	public String UserLocalIP() throws RemoteException;

	public String UserIp() throws RemoteException;

	public String UserLocation() throws RemoteException;
	
	public int User_Pin_Number_Verification() throws RemoteException;
	
	public void Customer_Chart() throws RemoteException; 
	
	public String MainBalance() throws RemoteException;

}
