package objetos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {

	private ArrayList<ItemMenu> bebidas = new ArrayList<ItemMenu>();
	private ArrayList<ItemMenu> platos = new ArrayList<ItemMenu>();
	private String estado;
	private RegistroDePedido registro;
	private static final String confirmado = "CONFIRMADO";
	private static final String noConfirmado = "NO CONFIRMADO";

	public Pedido(ArrayList<ItemMenu> bebidas, ArrayList<ItemMenu> platos, RegistroDePedido registro) {
		this.bebidas.addAll(bebidas);
		this.platos.addAll(platos);
		this.estado = noConfirmado;
		this.registro = registro;
	}

	public double pagarPedido(Tarjeta tarjeta) {
		double monto = tarjeta.calcularGasto(this.montoDeBebidas(), this.montoDePlatos());
		String fechaString = String.format("%1$td/%1$tm/%1$tY", LocalDate.now());
		registro.registrarPedido(fechaString + " || " + monto + "\n");

		return monto;
	}

	protected boolean estaConfirmado() {

		return this.estado.equals(confirmado);
	}

	public void confirmarPedido() {

		if (!this.estaConfirmado())
			this.estado = confirmado;
		else
			System.out.println("Ya se encuentra confirmado");
	}

	public double montoDeBebidas() {

		double montoBebidas = 0;

		for (ItemMenu i : this.bebidas) {

			montoBebidas = montoBebidas + i.precioItem();
		}
		return montoBebidas;
	}

	public double montoDePlatos() {

		double montoPlatos = 0;

		for (ItemMenu i : this.platos) {
			montoPlatos = montoPlatos + i.precioItem();
		}

		return montoPlatos;
	}

}
