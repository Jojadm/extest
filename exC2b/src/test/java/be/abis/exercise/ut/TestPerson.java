package be.abis.exercise.ut;

import be.abis.exercise.exceptions.PersonShouldBeAdultException;
import be.abis.exercise.exceptions.SalaryTooLowException;
import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestPerson {

    private Person personUnderTest;

    @Mock
    Company companyMock;

    @Before
    public void setUp() {

        personUnderTest = new Person(1, "Sonja", "De Meersman", LocalDate.of(1977, 12, 21));
    }

    @Test
    public void personShouldBe42() throws PersonShouldBeAdultException{
        //arrange
        //act
        int result= personUnderTest.calculateAge();
        //assert
        assertEquals(42,result);

    }
    @Test
    public void personShouldBe42withHamcrest() throws PersonShouldBeAdultException {
        //arrange
        //act
        int result= personUnderTest.calculateAge();
        //assert
        assertThat(result, equalTo(42));

    }

    @Test
    public void toStringSentenceStartsWithPerson() {
        //arrange
        //act
        String result = personUnderTest.toString();
        //assert
        assertThat(result, startsWith("Person"));

    }

    @Test(expected = PersonShouldBeAdultException.class)
    public void personLessThen18Exception() throws PersonShouldBeAdultException {
        //arrange
        personUnderTest.setBirthDay(LocalDate.of(2004, 12, 21));
        //act
        int result = personUnderTest.calculateAge();
        //assert - mag weg bij testen van exception
        //assertEquals(16,result);
    }

    @Test
    public void calculateNetSalaryOfBelgianPersonUsingMockCompany() throws SalaryTooLowException {
        //arrange
        personUnderTest = new Person(1, "Sonja", "De Meersman", LocalDate.of(1977, 12, 21),companyMock, 3500);
        when(companyMock.calculateTaxToPay()).thenReturn(51.0);
        //act
        double netSalary = personUnderTest.calculateNetSalary();
        //assert
        verify(companyMock).calculateTaxToPay();
    }

    @Test(expected = SalaryTooLowException.class)
    public void salaryTooLowException() throws SalaryTooLowException{
        //arrange
        personUnderTest = new Person(1, "Sonja", "De Meersman", LocalDate.of(1977, 12, 21),companyMock, 2000);
        when(companyMock.calculateTaxToPay()).thenReturn(51.0);
        //act

        double netSalary = personUnderTest.calculateNetSalary();
        //assert
        verify(companyMock).calculateTaxToPay();
    }
}
