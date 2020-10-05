package be.abis.exercise.ut2;

import be.abis.exercise.exceptions.PersonShouldBeAdultException;
import be.abis.exercise.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPerson {

    private Person personUnderTest;

    @BeforeEach
    public void setUp() {
        System.out.println("BeforeEach");
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
        personUnderTest = new Person(1, "Sonja", "De Meersman", LocalDate.of(1977, 12, 21));
        //act
        int result= personUnderTest.calculateAge();
        //assert
        assertThat(result, equalTo(42));

    }

    @Test
    public void toStringSentenceStartsWithPerson() {
        //arrange
        personUnderTest = new Person(1, "Sonja", "De Meersman", LocalDate.of(1977, 12, 21));
        //act
        String result = personUnderTest.toString();
        //assert
        assertThat(result, startsWith("Person"));

    }

    @Test
    public void personLessThen18Exception() throws PersonShouldBeAdultException {
        //arrange
        personUnderTest.setBirthDay(LocalDate.of(2004, 12, 21));
        //act
        assertThrows(PersonShouldBeAdultException.class, () -> {
            personUnderTest.calculateAge();
        });
        //assert - mag weg bij testen van exception
        //assertEquals(16,result);

    }
}
