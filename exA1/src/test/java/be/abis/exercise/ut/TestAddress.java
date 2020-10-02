package be.abis.exercise.ut;

import be.abis.exercise.model.Address;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAddress {

    @Test
    public void belgianZipCodeShouldBeNumeric() {
        //arrange
        Address addressUnderTest = new Address("Mutsereelstraat","27", "9310", "Aalst", "België", "BE");
        //act
        //assert
        assertTrue(addressUnderTest.checkBelgianZipCode());
    }
}
