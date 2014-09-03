package utn.dds.tp;

import utn.dds.tp.Jugador;
import utn.dds.tp.Partido;

public abstract class Observador {
	public abstract void notificarNuevaInscripcion(Jugador jugador, Partido partido);
	public abstract void notificarReemplazoDeInscSinSustituto(Partido partido);
	public abstract void notificarPartidoConfirmado(Partido partido);
}


