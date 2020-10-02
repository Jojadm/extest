package be.abis.exercise.ut;

import be.abis.exercise.model.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TestPerson {

    @Test
    public void personShouldBe42() {
        //arrange
        Person personUnderTest = new Person(1, "Sonja", "De Meersman", LocalDate.of(1977, 12, 21));
        //act
        int result= personUnderTest.calculateAge();
        //assert
        assertEquals(42,result);

    }
}
