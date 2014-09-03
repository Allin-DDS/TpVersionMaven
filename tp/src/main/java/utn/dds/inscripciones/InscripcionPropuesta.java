package utn.dds.inscripciones;

import utn.dds.tp.Inscripcion;
import  utn.dds.tp.Partido;

public class InscripcionPropuesta {
	private Partido partido;
	private Inscripcion inscripcion;
	
	public InscripcionPropuesta(Inscripcion inscripcion, Partido partido){
		this.inscripcion=inscripcion;
		this.partido=partido;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Inscripcion getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}
	
}
