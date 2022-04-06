package objetos;

import java.util.ArrayList;

import persistence.ArchivoRegistroDePedido;

public class PedidoMain {

	public static void main(String[] args) {

		ArchivoRegistroDePedido registro = new ArchivoRegistroDePedido();
		ArrayList<ItemMenu> bebidas = new ArrayList<ItemMenu>();
		ArrayList<ItemMenu> platos = new ArrayList<ItemMenu>();

		Tarjeta visa = new Visa();

		ItemMenu bebidaA = new ItemMenu("gaseosa", 25);
		ItemMenu bebidaB = new ItemMenu("Agua", 25);
		ItemMenu platoA = new ItemMenu("Hamburguesa", 25);
		ItemMenu platoB = new ItemMenu("Pizza", 25);

		bebidas.add(bebidaA);
		bebidas.add(bebidaB);
		platos.add(platoA);
		platos.add(platoB);

		Pedido pedido = new Pedido(bebidas, platos, registro);
		pedido.confirmarPedido();
		pedido.pagarPedido(visa);

	}

}
