package utn.dds.observers;

import  utn.dds.tp.Jugador;
import utn.dds.tp.Observador;
import utn.dds.tp.Partido;


public class MailAAmigos extends Observador{

	public void notificarReemplazoDeInscSinSustituto(Partido partido) {
		// TODO Auto-generated method stub
		// método vacío
	}
	
	public void notificarNuevaInscripcion(Jugador emisor, Partido partido) {
		// TODO Auto-generated method stub
		//Aca avisara a los amigos del jugador inscripto 
	}

	public void notificarPartidoConfirmado(Partido partido) {
		// TODO Auto-generated method stub
		// método vacío
	}
}
