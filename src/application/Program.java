package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		char option;

		System.out.print("Enter the number of taxpayers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("Taxpayer #" + i + " data: ");

			do {

				System.out.print("Individual or company(i/c)? ");
				option = sc.next().charAt(0);

				if (option != 'i' && option != 'I' && option != 'c' && option != 'C')
					System.out.println("Unknown command!");

			} while (option != 'i' && option != 'I' && option != 'c' && option != 'C');

			if (option == 'i' || option == 'I') {

				System.out.print("Name: ");
				sc.nextLine();
				String individualName = sc.nextLine();
				System.out.print("Anual income: ");
				double anualIncome = sc.nextDouble();
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();

				list.add(new Individual(individualName, anualIncome, healthExpenditures));

			} else if (option == 'c' || option == 'C') {

				System.out.print("Name: ");
				sc.nextLine();
				String companyName = sc.nextLine();
				System.out.print("Anual income: ");
				double anualIncome = sc.nextDouble();
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();

				list.add(new Company(companyName, anualIncome, numberOfEmployees));

			}
		}

		System.out.println();
		System.out.println("TAXES PAID: ");
		for (TaxPayer taxpayer : list) {
			System.out.printf("%s: $ %.2f%n", taxpayer.getName(), taxpayer.tax());
		}

		double totalTaxes = 0.0;
		for (TaxPayer taxpayer : list) {
			totalTaxes += taxpayer.tax();
		}

		System.out.println();
		System.out.printf("TOTAL TAXES: %.2f%n", totalTaxes);

		sc.close();

	}

}
