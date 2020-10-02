package be.abis.exercise.ut;

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
        System.out.println(personUnderTest);
    }

    @Test
    public void personShouldBe42() {
        //arrange
        //act
        int result= personUnderTest.calculateAge();
        //assert
        assertEquals(42,result);

    }
    @Test
    public void personShouldBe42withHamcrest() {
        //arrange
        Person personUnderTest = new Person(1, "Sonja", "De Meersman", LocalDate.of(1977, 12, 21));
        //act
        int result= personUnderTest.calculateAge();
        //assert
        assertThat(result, equalTo(42));

    }

    @Test
    public void toStringSentenceStartsWithPerson() {
        //arrange
        Person personUnderTest = new Person(1, "Sonja", "De Meersman", LocalDate.of(1977, 12, 21));
        //act
        String result = personUnderTest.toString();
        //assert
        assertThat(result, startsWith("Person"));

    }
}
