package objetos;

public class Mastercard extends Tarjeta {

	private double descuento = 0.02;

	public Mastercard() {
	}

	public double calcularGasto(double montoBebidas, double montoPlatos) {

		double montoTotal = (montoBebidas + montoPlatos) + (this.sumarPropina(montoBebidas + montoPlatos))
				- this.calcularDescuento(montoPlatos);

		return montoTotal;
	}

	protected double calcularDescuento(double monto) {

		double montoDescuento = monto * descuento;

		return montoDescuento;
	}

}
