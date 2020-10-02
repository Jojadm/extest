package be.abis.exercise.ut;

import be.abis.exercise.exceptions.PersonShouldBeAdultException;
import be.abis.exercise.model.Person;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestPerson {

    private Person personUnderTest;

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
}
