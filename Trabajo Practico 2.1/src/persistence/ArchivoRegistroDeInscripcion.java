package persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import objetos.RegistroDeInscripcion;

public class ArchivoRegistroDeInscripcion implements RegistroDeInscripcion {

	@Override
	public void registrarInscripcion(String registro) {

		try {
			Files.write(Paths.get("C:\\Users\\Valen\\Desktop\\tp 2 OO\\archivo inscripcion"), registro.getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("ERROR", e);
		}

	}

	@Override
	public String contenido() {
		// TODO Auto-generated method stub
		return null;
	}

}
