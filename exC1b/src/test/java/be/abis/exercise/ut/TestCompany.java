package be.abis.exercise.ut;

import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCompany {
    private static Address addressUnderTest;
    private static Company companyUnderTest;

    @Before
    public void setUp() {
        addressUnderTest = new Address("Mutsereelstraat","27", "9310", "Aalst", "België", "BE");
        companyUnderTest = new Company("Kwafsalon", addressUnderTest);
    }
    @Test
    public void taxForBelgianCompanyShouldBe51() {
        //arrange

        //act
        double tax = companyUnderTest.calculateTaxToPay();
        //assert
        assertEquals(51.0, tax, 0);
    }
}
