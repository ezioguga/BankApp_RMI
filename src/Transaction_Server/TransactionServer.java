package Transaction_Server;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class TransactionServer {

	public static void main(String [] args) {
		try {
			TransactionImplement Trans = new TransactionImplement();
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("Transaction", Trans);
			System.out.println("Transaction server is ready");
		}catch(RemoteException e){
			System.out.println("Transaction server: "+e.toString());
			e.printStackTrace();
		}
	}
}
