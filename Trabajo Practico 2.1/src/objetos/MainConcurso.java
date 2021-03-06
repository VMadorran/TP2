package objetos;

import java.time.LocalDate;

import persistence.ArchivoRegistroDeInscripcion;
import persistence.EnBaseRegistroDeInscripcion;

public class MainConcurso {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		LocalDate inicio = LocalDate.now().minusDays(3);
		LocalDate fin = LocalDate.now().plusDays(15);

		Concurso concurso = new Concurso(inicio, fin, 1, 50, new EnBaseRegistroDeInscripcion());
		Participante participante = new Participante(1);
		concurso.inscribirse(participante);

	}

}
