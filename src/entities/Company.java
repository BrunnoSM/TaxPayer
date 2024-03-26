package entities;

public class Company extends TaxPayer {

	private Integer numberOfEmployees;

	public Company() {
		super();
	}

	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public double tax() {

		/*
		 * Pessoas jurídicas pagam 16% de imposto. Porém, se a empresa possuir mais de
		 * 10 funcionários, ela paga 14% de imposto.
		 */

		// Operador Ternário
		double companyTax = (numberOfEmployees > 10) ? getAnualIncome() * 0.14 : getAnualIncome() * 0.16;

		return companyTax;

	}

}
