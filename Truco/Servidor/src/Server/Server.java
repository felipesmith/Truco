package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import interfaces.InterfaceRemota;
import RemoteObject.ObjetoRemoto;

public class Server {

	public Server() throws RemoteException{
		inicializar();
	}

	private void inicializar() throws RemoteException {
		
		InterfaceRemota or = new ObjetoRemoto();

		
		try {
			LocateRegistry.createRegistry(1099);
			Naming.rebind("//127.0.0.1/truco", or);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
