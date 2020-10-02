package be.abis.exercise.model;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.lang.Integer.*;

public class Address {
	
	private String street;
	private String nr;
	private String zipCode;
	private String town;
	private String country;
	private String countryCode;
	
	public Address(String street, String nr, String zipCode, String town, String country, String countryCode) {
		this.street = street;
		this.nr = nr;
		this.zipCode = zipCode;
		this.town = town;
		this.country = country;
		this.countryCode = countryCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public boolean checkBelgianZipCode(){
		try {
			Integer zip = Integer.parseInt(zipCode);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public String toString() {
		String text = "Address: " +street + " " +nr + ", " +zipCode + " " +town + " " +country ;
		return text;
	}

	public void writeAddress() {
		try(
			BufferedWriter bw = Files.newBufferedWriter(Paths.get("addressinfo.txt"), StandardOpenOption.APPEND, StandardOpenOption.CREATE)
			)
		{	bw.write(this.toString() + "\n");
			System.out.println("address written to file : " +this.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
