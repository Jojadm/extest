package be.abis.exercise.model;

import be.abis.exercise.exceptions.PersonShouldBeAdultException;
import be.abis.exercise.exceptions.SalaryTooLowException;

import java.time.LocalDate;
import java.time.Period;

public class Person {

	private int personNumber;
	private String firstName;
	private String lastName;
	private LocalDate birthDay;
	private Company company;
	private double grossSalary;


	public Person(int personNumber, String firstName, String lastName, LocalDate birthDay) {
		this.personNumber = personNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
	}

	public Person(int personNumber, String firstName, String lastName, LocalDate birthDay, Company company) {
		this(personNumber, firstName, lastName, birthDay);
		this.company = company;
	}

	public Person(int personNumber, String firstName, String lastName, LocalDate birthDay, Company company, double grossSalary) {
		this.personNumber = personNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.company = company;
		this.grossSalary = grossSalary;
	}

	public int getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(int personNumber) {
		this.personNumber = personNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setGrossSalary(double grossSalary) {this.grossSalary = grossSalary;	}

	public double getGrossSalary() {return grossSalary;	}

	@Override
	public String toString() {
		String text = null;
		try {
			text = "Person " + this.personNumber + ": " + this.firstName + " " + this.lastName + " (" + this.calculateAge() + " years old)";
			if (this.company != null) {
				text += " works for " + this.company.getName() + " in " + this.company.getAddress().getTown() + ".";
			} else {
				text += " is not employed for the moment.";
			}
		} catch (PersonShouldBeAdultException e) {
			System.out.println("severe error");
		}
		return text;
	}

	public int calculateAge() throws PersonShouldBeAdultException {
		int age = Period.between(birthDay, LocalDate.now()).getYears();
		if (age >= 18) {
			return age;
		} else {
			throw new PersonShouldBeAdultException("Person should be adult");
		}
	}

	public double calculateNetSalary() throws SalaryTooLowException {
		double tax = company.calculateTaxToPay();
		double netSalary = this.grossSalary - (this.grossSalary * tax / 100);
		if (netSalary > 1500) {
			return netSalary;
		} else {
			throw new SalaryTooLowException("Net Salary is too low");
		}
	}
}
