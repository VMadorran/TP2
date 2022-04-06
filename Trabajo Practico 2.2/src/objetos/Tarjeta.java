package objetos;

public class Tarjeta {

	private double descuento;

	public Tarjeta() {
	}

	protected double calcularGasto(double montoBebidas, double montoPlatos) {

		double gastoTotal = montoBebidas + montoPlatos;
		gastoTotal = gastoTotal + this.sumarPropina(gastoTotal);

		return gastoTotal;
	}

	protected double sumarPropina(double montoTotal) {

		if (montoTotal <= 5000)
			return this.calcularPropina(montoTotal, 0.02);
		else if (montoTotal < 10000)
			return this.calcularPropina(montoTotal, 0.03);
		else
			return this.calcularPropina(montoTotal, 0.05);
	}

	protected double calcularDescuento(double monto) {

		double montoDescuento = monto * descuento;

		return montoDescuento;
	}

	protected double calcularPropina(double monto, double porcentaje) {

		double propina = monto * porcentaje;

		return propina;
	}

}
