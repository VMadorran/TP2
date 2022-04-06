package objetos;

public class ComarcaPlus extends Tarjeta {

	private double descuento = 0.02;

	public ComarcaPlus() {
	}

	public double calcularGasto(double montoBebidas, double montoPlatos) {

		double gastoTotal = montoBebidas + montoPlatos - this.calcularDescuento(montoBebidas + montoPlatos)
				+ this.sumarPropina(montoBebidas + montoPlatos);

		return gastoTotal;
	}

	protected double calcularDescuento(double monto) {

		double montoDescuento = monto * descuento;

		return montoDescuento;
	}
}
