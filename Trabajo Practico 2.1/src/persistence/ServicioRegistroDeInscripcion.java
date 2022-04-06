package persistence;

import objetos.RegistroDeInscripcion;

public class ServicioRegistroDeInscripcion implements RegistroDeInscripcion {

	private String contenido;

	@Override
	public void registrarInscripcion(String registro) {
		// TODO Auto-generated method stub
		this.contenido = registro;
	}

	@Override
	public String contenido() {
		// TODO Auto-generated method stub
		return this.contenido;
	}

}
