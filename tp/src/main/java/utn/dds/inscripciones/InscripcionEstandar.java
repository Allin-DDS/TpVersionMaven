package utn.dds.inscripciones;

import  utn.dds.tp.Inscripcion;
import  utn.dds.tp.Jugador;

public class InscripcionEstandar extends Inscripcion {
	
	public InscripcionEstandar(Jugador jugador){
		this.jugador=jugador;
		this.prioridad=1;
	}
	
	
}