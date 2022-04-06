package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import objetos.Concurso;
import objetos.Participante;
import persistence.ServicioRegistroDeInscripcion;

public class ConcursoTest {
	ServicioRegistroDeInscripcion servicio = new ServicioRegistroDeInscripcion();

	@Test
	public void inscripcionParticipante() {

		LocalDate inicio = LocalDate.now().minusDays(3);
		LocalDate fin = LocalDate.now().plusDays(15);

		Concurso concurso = new Concurso(inicio, fin, 1, 50, servicio);
		Participante participante = new Participante(1);
		boolean resultado = concurso.inscribirse(participante);

		String fechaString = String.format("%1$td/%1$tm/%1$tY", LocalDate.now());
		String datoGuardado = fechaString + ", " + "1" + ", " + "1" + "\n";

		assertEquals(true, resultado);
		assertEquals(datoGuardado, servicio.contenido());

	}

	@Test
	public void inscripcionPrimerDia() {

		LocalDate inicio = LocalDate.now();
		LocalDate fin = LocalDate.now().plusDays(15);

		Concurso concurso = new Concurso(inicio, fin, 2, 20, servicio);
		Participante participante = new Participante(2);
		int puntosParticipante = participante.puntosParticipante();
		concurso.inscribirse(participante);

		String fechaString = String.format("%1$td/%1$tm/%1$tY", LocalDate.now());
		String datoGuardado = fechaString + ", " + "2" + ", " + "2" + "\n";

		assertEquals(puntosParticipante + 10, participante.puntosParticipante());
		assertEquals(datoGuardado, servicio.contenido());
	}

	@Test
	public void inscripcionFueraDeTermino() {

		LocalDate inicio = LocalDate.now().minusMonths(2);
		LocalDate fin = LocalDate.now().minusMonths(1);

		Concurso concurso = new Concurso(inicio, fin, 3, 30, servicio);
		Participante participante = new Participante(3);

		assertEquals(false, concurso.inscribirse(participante));
	}

}
