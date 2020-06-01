package Authentication_Server;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AuthentictationServer {

	public static void main(String[] args) {
		try {
			AuthenticationImplement myAuth = new AuthenticationImplement(); //local object
			Registry reg = LocateRegistry.createRegistry(1098);
			reg.rebind("Authentication", myAuth);
			System.out.println("Authentication server is ready");
		}catch(RemoteException e){
			System.out.println("Authentication server: "+e.toString());
			e.printStackTrace();
		}
	}
	
}
