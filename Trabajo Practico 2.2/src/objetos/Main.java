package objetos;

import java.time.LocalDate;
import java.util.ArrayList;

import persistence.EnBaseRegistroDePedido;
import persistence.ServicioRegistroDePedido;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ItemMenu> bebidas = new ArrayList<ItemMenu>();
		ArrayList<ItemMenu> platos = new ArrayList<ItemMenu>();
		EnBaseRegistroDePedido servicio = new EnBaseRegistroDePedido();

		Tarjeta tarjeta = new Tarjeta();
		ItemMenu bebidaA = new ItemMenu("gaseosa", 25);
		ItemMenu bebidaB = new ItemMenu("Agua", 25);
		ItemMenu platoA = new ItemMenu("Hamburguesa", 25);
		ItemMenu platoB = new ItemMenu("Pizza", 25);

		bebidas.add(bebidaA);
		bebidas.add(bebidaB);
		platos.add(platoA);
		platos.add(platoB);

		Pedido pedido = new Pedido(bebidas, platos, servicio);
		pedido.confirmarPedido();
		pedido.pagarPedido(tarjeta);

		System.out.println(servicio.contenido());
	}

}
