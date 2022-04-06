package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import objetos.ComarcaPlus;
import objetos.ItemMenu;
import objetos.Mastercard;
import objetos.Pedido;
import objetos.Tarjeta;
import objetos.Visa;
import persistence.ServicioRegistroDePedido;

public class TarjetaTest {

	ArrayList<ItemMenu> bebidas = new ArrayList<ItemMenu>();
	ArrayList<ItemMenu> platos = new ArrayList<ItemMenu>();

	Tarjeta tarjeta = new Tarjeta();
	Tarjeta visa = new Visa();
	Tarjeta mastercard = new Mastercard();
	Tarjeta comarca = new ComarcaPlus();
	ServicioRegistroDePedido servicio = new ServicioRegistroDePedido();

	@Test
	public void calcularCostoTarjetaVisa() {

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

		String fechaString = String.format("%1$td/%1$tm/%1$tY", LocalDate.now());
		double montoTotal = pedido.pagarPedido(visa);
		
		assertEquals(100.5, montoTotal);
		assertEquals(fechaString + " || " + montoTotal + "\n", servicio.contenido());
	}

	@Test
	public void calcularCostoTarjetaMastercard() {

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

		String fechaString = String.format("%1$td/%1$tm/%1$tY", LocalDate.now());
		
		double montoTotal = pedido.pagarPedido(mastercard);

		assertEquals(101, montoTotal);
		assertEquals(fechaString + " || " + montoTotal + "\n", servicio.contenido());
	}

	@Test
	public void calcularCostoTarjetaComarcaPlus() {

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

		double montoTotal = pedido.pagarPedido(comarca);
		
		String fechaString = String.format("%1$td/%1$tm/%1$tY", LocalDate.now());

		assertEquals(100, montoTotal);
		assertEquals(fechaString + " || " + montoTotal + "\n", servicio.contenido());
	}

	@Test
	public void calcularCostoTarjetaViedma() {

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

		String fechaString = String.format("%1$td/%1$tm/%1$tY", LocalDate.now());

		double montoTotal = pedido.pagarPedido(tarjeta);

		assertEquals(102, montoTotal);
		assertEquals(fechaString + " || " + montoTotal + "\n", servicio.contenido());
	}

}
