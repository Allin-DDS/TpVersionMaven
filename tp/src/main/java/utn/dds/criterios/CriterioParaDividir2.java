package utn.dds.criterios;

import java.util.Collection;
import java.util.PriorityQueue;

import utn.dds.tp.CriterioParaDividirEquipos;
import utn.dds.tp.Inscripcion;

public class CriterioParaDividir2 implements CriterioParaDividirEquipos {
	public void dividirEquipos(Collection<Inscripcion> equipo1, Collection<Inscripcion> equipo2, PriorityQueue<Inscripcion> primeros10Ordenados){
		equipo1.add(primeros10Ordenados.poll());
		equipo2.add(primeros10Ordenados.poll());
		equipo2.add(primeros10Ordenados.poll());
		equipo1.add(primeros10Ordenados.poll());
		equipo1.add(primeros10Ordenados.poll());
		equipo2.add(primeros10Ordenados.poll());
		equipo2.add(primeros10Ordenados.poll());
		equipo1.add(primeros10Ordenados.poll());
		equipo1.add(primeros10Ordenados.poll());
		equipo2.add(primeros10Ordenados.poll());
	}
}

