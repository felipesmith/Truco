package RemoteObject;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import Modelo.ControladorJugadores;
import DTO.JugadoresDTO;
import InterfaceRemotaTruco;


public class ObjetoRemotoTruco extends UnicastRemoteObject implements InterfaceRemotaTruco {

	private static final long serialVersionUID = 1L;
	private List<Jugador> jugadores;
	private List<Grupo> grupos;
	
	public void darAltaJugador(){
		return ControladorJugadores.getInstancia().darAltaJugador();
	}
	
	public List<Jugador> getJugadores() throws  RemoteException{
		return ControladorJugadores.getInstancia().getJugadores();
	}
	
	public List<Grupo> getGrupos() throws  RemoteException{
		return ControladorJugadores.getInstancia().getGrupos();
	}
}
