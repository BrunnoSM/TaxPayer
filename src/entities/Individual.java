package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;

	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double tax() {

		/*
		 * Pessoas cuja renda for abaixo de 20000.00(vinte mil) pagam 15% de imposto.
		 * Pessoas com renda de 20000.00(vinte mil) em diante pagam 25% de imposto. Se a
		 * pessoa teve gastos com saúde, 50% destes gastos são abatidos no imposto.
		 */

		double basicTax;

		// Operador Ternário
		basicTax = (getAnualIncome() < 20000.0) ? getAnualIncome() * 0.15 : getAnualIncome() * 0.25;

		// Gastos com Saúde
		basicTax -= getHealthExpenditures() * 0.5;

		// Não retornar imposto negativo
		basicTax = (basicTax < 0.0) ? 0.0 : basicTax;

		return basicTax;
	}

}
