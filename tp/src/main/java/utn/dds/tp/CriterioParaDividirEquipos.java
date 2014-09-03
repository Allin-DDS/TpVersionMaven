package utn.dds.tp;
import java.util.Collection;
import java.util.PriorityQueue;

public interface CriterioParaDividirEquipos {
	public void dividirEquipos(Collection<Inscripcion> equipo1, Collection<Inscripcion> equipo2,
			PriorityQueue<Inscripcion> primeros10Ordenados);
}