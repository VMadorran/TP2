package persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import objetos.RegistroDePedido;

public class ArchivoRegistroDePedido implements RegistroDePedido {

	@Override
	public void registrarPedido(String pedido) {
		// TODO Auto-generated method stub
		try {
			Files.write(Paths.get("C:\\Users\\Valen\\Desktop\\tp2OO\\archivo pedido"), pedido.getBytes(),
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
