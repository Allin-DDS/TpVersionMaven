package utn.dds.criterios;

import  utn.dds.tp.CriterioDeOrden;
import  utn.dds.tp.Jugador;

public class CriterioHandicap implements CriterioDeOrden {

	public double obtenerPromedio(Jugador jugador) {
		return jugador.getHandicap();
	}
}