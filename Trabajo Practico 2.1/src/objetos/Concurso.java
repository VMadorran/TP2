package objetos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
	private ArrayList<Inscripcion> inscriptos = new ArrayList<>();
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int puntosConcurso;
	private int id;
	private RegistroDeInscripcion registroDeInscripcion;

	public Concurso(LocalDate fechaInicio, LocalDate fechaFin, int id, int puntosConcurso,
			RegistroDeInscripcion registroDeInscripcion) {

		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.puntosConcurso = puntosConcurso;
		this.registroDeInscripcion = registroDeInscripcion;
		this.id = id;
	}

	public boolean inscribirse(Participante participante) {
		if (this.inscripcionEnTermino()) {
			Inscripcion nuevaInscripcion = new Inscripcion(participante);
			this.inscriptos.add(nuevaInscripcion);
			String fechaString = String.format("%1$td/%1$tm/%1$tY", LocalDate.now());
			String inscripcion = fechaString + ", " + participante.idParticipante() + ", " + this.id + "\n";
			this.registroDeInscripcion.registrarInscripcion(inscripcion);
			if (LocalDate.now().equals(fechaInicio))
				participante.agregarPuntos(10);
			return true;
		}
		return false;
	}

	private boolean inscripcionEnTermino() {
		LocalDate inscripcion = LocalDate.now();
		if (((inscripcion.isAfter(fechaInicio)) || (inscripcion.isEqual(fechaInicio)))
				&& ((inscripcion.isBefore(fechaFin)) || (inscripcion.isEqual(fechaFin)))) {
			return true;
		}
		return false;
	}
}
