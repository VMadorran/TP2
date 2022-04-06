package objetos;

public class Visa extends Tarjeta {

	private double descuento = 0.03;

	public Visa() {

	}

	public double calcularGasto(double montoBebidas, double montoPlatos) {

		double gastoTotal = (montoBebidas + montoPlatos) - this.calcularDescuento(montoBebidas)
				+ this.sumarPropina(montoBebidas + montoPlatos);

		return gastoTotal;
	}

	protected double calcularDescuento(double monto) {

		double montoDescuento = monto * descuento;

		return montoDescuento;
	}
}
