
import java.util.*;

import Controlador.Controlador;
import Exceptions.ClienteException;
import Negocio.Login;
import Negocio.Venta.Comercio;
import Negocio.Venta.CuentaCorriente;
import Negocio.Venta.Pedido;

/**
 * 
 */
public class ControladorJugadores {
	
	private static ControladorJugadores instancia;
	private List<Jugador> jugadores;
	private List<Grupo> grupos;

    /**
     * Default constructor
     */
    private ControladorJugadores() {
    	this.jugadores = JugadorDAO.getInstancia().getAll();
    	this.grupos = GrupoDAO.getInstancia().getAll();
    }

    public Boolean buscarJugadorEmailApodo(String email, String apodo) {
    	for (Jugador j:jugadores){
			if ((j.getEmail()== email) || (j.getApodo()== apodo)){
				return true;
			}
		}
        return false;
    }
    
    

    public void registrarJugador( String email, String apodo, String contrasena) {
    	if (jugadores.size()!=0){
			for (Jugador j: jugadores) {
				if (j.getEmail().equalsIgnoreCase(
						email));
					throw new JugadorException("El jugador ingresado ya existe");
			}
		}	

		Jugador jugador = new Jugador(email,apodo,contrasena);
		System.out.println("listo");
	}
    	

    public Boolean login( String apodo,  String contrasena) {
        
        return null;
    }
    public Collection<Jugador> buscarJugadoresCategoria(void String categoria) {
        // TODO implement here
        return null;
    }

    /**
     * @param String apodo 
     * @return
     */
    public Jugador buscarJugador(void String apodo) {
        // TODO implement here
        return null;
    }

    /**
     * @param Jugador jugador 
     * @return
     */
    public String calcularCategoriaJugador(Jugador jugador) {
        // TODO implement here
        return "";
    }

    /**
     * @param Jugador jugador 
     * @param Categoria catregoria 
     * @return
     */
    public Boolean actualizarCategoriaJugador(void Jugador jugador, void Categoria catregoria) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Collection<Jugadores> listarJugadores() {
        // TODO implement here
        return null;
    }

    /**
     * @param String nombre 
     * @return
     */
    public Grupo buscarGrupo(void String nombre) {
        // TODO implement here
        return null;
    }

    /**
     * @param Jugador administrador 
     * @param String nombre 
     * @return
     */
    public Grupo crearGrupo(void Jugador administrador, void String nombre) {
        // TODO implement here
        return null;
    }

    /**
     * @param Grupo grupo 
     * @param Jugador jugador 
     * @return
     */
    public Grupo agregarJugadorGrupo(void Grupo grupo, void Jugador jugador) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Collection<Jugadores> obtenerRanking() {
        // TODO implement here
        return null;
    }

    /**
     * @param Jugador jugador1 
     * @param Jugador jugador2 
     * @return
     */
    public void crearPareja(void Jugador jugador1, void Jugador jugador2) {
        // TODO implement here
        return null;
    }

    /**
     * @param Jugador jugador 
     * @return
     */
    public Pareja armarParejaLibre(void Jugador jugador) {
        // TODO implement here
        return null;
    }

    /**
     * @param Pareja pareja1 
     * @param Pareja pareja2 
     * @return
     */
    public void crearPartida(void Pareja pareja1, void Pareja pareja2) {
        // TODO implement here
        return null;
    }

	public static Controlador getInstancia() {
		if (instancia == null)
			instancia = new Controlador();
		return instancia;
	}

}