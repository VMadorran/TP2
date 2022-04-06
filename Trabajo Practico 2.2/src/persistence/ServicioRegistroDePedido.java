package persistence;

import objetos.RegistroDePedido;

public class ServicioRegistroDePedido implements RegistroDePedido {

	private String contenido;

	@Override
	public void registrarPedido(String pedido) {
		// TODO Auto-generated method stub
		this.contenido = pedido;
	}

	@Override
	public String contenido() {
		// TODO Auto-generated method stub
		return this.contenido;
	}

}
