package utn.dds.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test; 
import java.time.LocalDate;
import java.time.LocalTime;
import utn.dds.exception.*;
import utn.dds.tp.Condicion;
import utn.dds.criterios.CriterioHandicap;
import utn.dds.criterios.CriterioParesEImpares;
import utn.dds.inscripciones.InscripcionCondicional;
import utn.dds.inscripciones.InscripcionEstandar;
import utn.dds.inscripciones.InscripcionSolidaria;
import utn.dds.tp.Jugador;
import utn.dds.observers.MailAAdministrador;
import utn.dds.observers.MailAAmigos;
import utn.dds.tp.Partido;

public class TestTPA {

	private Partido semifinal;
	private Jugador juan;
	private InscripcionEstandar inscripcionJuan;
	private Jugador esteban;
	private InscripcionEstandar inscripcionEsteban;
	private Jugador ramiro;
	private InscripcionEstandar inscripcionramiro;
	private Jugador mario;
	private InscripcionEstandar inscripcionmario;
	private Jugador adrian;
	private InscripcionEstandar inscripcionadrian;
	private Jugador marcos;
	private InscripcionEstandar inscripcionmarcos;
	private Jugador carlos;
	private InscripcionEstandar inscripcioncarlos;
	private Jugador turco;
	private	InscripcionEstandar inscripcionturco;
	private Jugador coqui;
	private	InscripcionEstandar inscripcioncoqui;
	private Jugador mati;
	private	InscripcionEstandar inscripcionmati;
	
	private Jugador jose;
	private InscripcionCondicional inscripcionJose;
	private Condicion condicionJose;
	private Jugador franco;
	private InscripcionCondicional inscripcionfranco;
	private Condicion condicionfranco;
	private Jugador dani;
	private InscripcionCondicional inscripciondani;
	private Condicion condiciondani;

	private Jugador maria;
	private InscripcionSolidaria inscripcionMaria;
	private Jugador gordo;
	private InscripcionSolidaria inscripciongordo;
	
	private MailAAdministrador mailAAdministradorMock;
	private MailAAmigos mailAAmigosMock;
	private CriterioHandicap criterioHandicap;
	private CriterioParesEImpares criterioParesEImpares;
	
	@Before
	public void init(){
		LocalDate hoy=LocalDate.now();
		LocalTime hora=LocalTime.of(22,00);
		semifinal= new Partido(hoy,hora,"calleFalsa1234");
		
		juan= new Jugador(21);
		juan.setHandicap(1);
		inscripcionJuan= new InscripcionEstandar(juan);
		esteban= new Jugador(21);
		esteban.setHandicap(2);
		inscripcionEsteban= new InscripcionEstandar(esteban);
		ramiro= new Jugador(21);
		ramiro.setHandicap(3);
		inscripcionramiro= new InscripcionEstandar(ramiro);
		mario= new Jugador(21);
		mario.setHandicap(4);
		inscripcionmario= new InscripcionEstandar(mario);
		adrian= new Jugador(21);
		adrian.setHandicap(5);
		inscripcionadrian= new InscripcionEstandar(adrian);
		marcos= new Jugador(21);
		inscripcionmarcos= new InscripcionEstandar(marcos);
		carlos= new Jugador(21);
		inscripcioncarlos= new InscripcionEstandar(carlos);
		turco= new Jugador(21);	
		inscripcionturco= new InscripcionEstandar(turco);
		coqui= new Jugador(21);
		inscripcioncoqui= new InscripcionEstandar(coqui);
		mati= new Jugador(21);
		inscripcionmati= new InscripcionEstandar(mati);

		jose= new Jugador(21);
		jose.setHandicap(6);
		condicionJose = new Condicion();
		inscripcionJose= new InscripcionCondicional(jose,condicionJose);
		franco= new Jugador(21);
		franco.setHandicap(7);
		condicionfranco = new Condicion();
		inscripcionfranco= new InscripcionCondicional(franco,condicionfranco);
		dani= new Jugador(21);
		dani.setHandicap(8);
		condiciondani = new Condicion();
		inscripciondani= new InscripcionCondicional(dani,condiciondani);
	
		maria= new Jugador(21);
		maria.setHandicap(9);
		inscripcionMaria= new InscripcionSolidaria(maria);
		gordo= new Jugador(21);
		gordo.setHandicap(10);
		inscripciongordo= new InscripcionSolidaria(gordo);
		
		mailAAdministradorMock= mock(MailAAdministrador.class);
		mailAAmigosMock= mock(MailAAmigos.class);
	
		criterioHandicap= new CriterioHandicap();
		criterioParesEImpares= new CriterioParesEImpares();
		
	}
	
	@Test 
	public void agregar1Condicional_ContarLosCondicionales(){
		semifinal.altaInscripcion(inscripcionJose);
		assertEquals(1,semifinal.cantidadInscriptosCondicionales());
	}
	
	@Test 
	public void agregar2Estandar_ContarLosEstandar(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionEsteban);
		assertEquals(2,semifinal.cantidadInscriptosEstandar());
	}
	
	@Test 
	public void agregar2Solidarios_ContarLosSolidarios(){
		semifinal.altaInscripcion(inscripciongordo);
		semifinal.altaInscripcion(inscripcionMaria);
		assertEquals(2,semifinal.cantidadInscriptosSolidarios());
	}
	
	
	@Test 
	public void agregar2Estandar2SolidariaY1Condicional_cantidadTotalInscriptos(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionEsteban);
		
		semifinal.altaInscripcion(inscripcionJose);
		
		semifinal.altaInscripcion(inscripcionMaria);
		semifinal.altaInscripcion(inscripciongordo);
		
		assertEquals(5,semifinal.cantidadTotalInscriptos());
	}
	
	@Test
	public void agregar2Solidarios1Estandar1Condicional_VerificarOrdenCorrecto(){
		semifinal.altaInscripcion(inscripcionMaria);
		semifinal.altaInscripcion(inscripciongordo);
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionJose);
		
		assertEquals(inscripcionJuan,semifinal.getInscripciones().poll());
		assertEquals(inscripcionJose,semifinal.getInscripciones().poll());
		assertEquals(inscripciongordo,semifinal.getInscripciones().poll());
		assertEquals(inscripcionMaria,semifinal.getInscripciones().poll());		
	}
	
	@Test (expected=Hay10EstandarException.class)
	public void agregar10EstandarY1Solidaria_Hay10EstandarException(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionEsteban);
		semifinal.altaInscripcion(inscripcionramiro);
		semifinal.altaInscripcion(inscripcionmario);
		semifinal.altaInscripcion(inscripcionadrian);
		semifinal.altaInscripcion(inscripcionmarcos);
		semifinal.altaInscripcion(inscripcioncarlos);
		semifinal.altaInscripcion(inscripcionturco);
		semifinal.altaInscripcion(inscripcioncoqui);
		semifinal.altaInscripcion(inscripcionmati);
		
		semifinal.altaInscripcion(inscripcionMaria);
	}
	
	@Test
	public void reemplazo1SolidarioSinSustituto_AgregarInfraccion(){
		semifinal.altaInscripcion(inscripcionMaria);
		semifinal.BajaInscripcion(inscripcionMaria,null);
		
		assertEquals(1,maria.getCantidadInfracPorNoTenerSustituto());	
	}
	
	@Test
	public void agregarInscripcion_AvisarAAdmin(){
		semifinal.altaInscripcion(inscripcionJuan);
		mailAAdministradorMock.notificarNuevaInscripcion(juan,semifinal);
		verify(mailAAdministradorMock).notificarNuevaInscripcion(juan,semifinal);
	}
	
	@Test
	public void agregarInscripcion_AvisarAAMigos(){
		semifinal.altaInscripcion(inscripcionJuan);
		mailAAmigosMock.notificarNuevaInscripcion(juan,semifinal);
		verify(mailAAmigosMock).notificarNuevaInscripcion(juan,semifinal);
	}
	
	@Test
	public void reemplazarInscripcionSinSusitucion_AvisarAAdmin(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.BajaInscripcion(inscripcionJuan, null);
		mailAAdministradorMock.notificarReemplazoDeInscSinSustituto(semifinal);
		verify(mailAAdministradorMock).notificarReemplazoDeInscSinSustituto(semifinal);
	}
	
	@Test
	public void reemplazarInscripcionSinSusitucion_AvisarAAmigos(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.BajaInscripcion(inscripcionJuan, null);
		mailAAmigosMock.notificarReemplazoDeInscSinSustituto(semifinal);
		verify(mailAAmigosMock).notificarReemplazoDeInscSinSustituto(semifinal);
	}
	
	
	@Test(expected=NoHay10InscriptosParaGenerarEquiposException.class)
	public void agregar5Estandar3CondicionalYGenerarEquipos_SeGeneraExcepcionPqNoHay10Inscriptos(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionEsteban);
		semifinal.altaInscripcion(inscripcionramiro);
		semifinal.altaInscripcion(inscripcionmario);
		semifinal.altaInscripcion(inscripcionadrian);
	
		semifinal.altaInscripcion(inscripciondani);
		semifinal.altaInscripcion(inscripcionfranco);
		semifinal.altaInscripcion(inscripcionJose);
		
		semifinal.generarEquipos(semifinal.getInscripciones());
}	
	
	@Test
	public void ordenarInscriptosConCriterioHandicaoYgenerarEquiposConCriterioParEImpar(){
		semifinal.altaInscripcion(inscripcionJuan);
		semifinal.altaInscripcion(inscripcionEsteban);
		semifinal.altaInscripcion(inscripcionramiro);
		semifinal.altaInscripcion(inscripcionmario);
		semifinal.altaInscripcion(inscripcionadrian);
	
		semifinal.altaInscripcion(inscripciondani);
		semifinal.altaInscripcion(inscripcionfranco);
		semifinal.altaInscripcion(inscripcionJose);
	
		semifinal.altaInscripcion(inscripcionMaria);
		semifinal.altaInscripcion(inscripciongordo);
		
		semifinal.agregarCriterioDeOrden(criterioHandicap);
		semifinal.setCriterioParaDividirEquipos(criterioParesEImpares);
		semifinal.generarEquipos(semifinal.ordenarPrimeros10());
			
		assertTrue(semifinal.getEquipo1().contains(inscripcionJuan));
		assertTrue(semifinal.getEquipo1().contains(inscripcionramiro));
		assertTrue(semifinal.getEquipo1().contains(inscripcionadrian));
		assertTrue(semifinal.getEquipo1().contains(inscripcionfranco));
		assertTrue(semifinal.getEquipo1().contains(inscripcionMaria));
	 	assertTrue(semifinal.getEquipo2().contains(inscripcionEsteban));
		assertTrue(semifinal.getEquipo2().contains(inscripcionmario));
		assertTrue(semifinal.getEquipo2().contains(inscripciondani));
		assertTrue(semifinal.getEquipo2().contains(inscripcionJose));
		assertTrue(semifinal.getEquipo2().contains(inscripciongordo));
	}
	
}

