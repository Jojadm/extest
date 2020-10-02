package be.abis.exercise.ut;

import be.abis.exercise.exceptions.PersonShouldBeAdultException;
import be.abis.exercise.model.Address;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestAddress {

    private static Address addressUnderTest;
    private static File file;

    @BeforeClass
    public static void setUp() {
        addressUnderTest = new Address("Mutsereelstraat","27", "9310", "Aalst", "België", "BE");
    }

    @Before
    public void beforeEachTest() {
        file = new File("addressinfo.txt");
        file.setWritable(true);
    }

    @Test
    public void belgianZipCodeShouldBeNumeric() {
        //arrange
        //act
        //assert
        assertTrue(addressUnderTest.checkBelgianZipCode());
    }

    @Test(expected = IOException.class)
    public void addressFileIOExceptionReadOnly() throws IOException {
        //arrange

        file.setReadOnly();
        //act
        addressUnderTest.writeAddress();
        //Assert

    }

    @Test
    public void writingAddressToFile() throws IOException {
        //arrange
        int nbrLinesBefore = 0, nbrLinesAfter = 0;
        //act
        nbrLinesBefore = readAddressInfoFile();
        addressUnderTest.writeAddress();
        nbrLinesAfter = readAddressInfoFile();
        //Assert
        assertEquals(nbrLinesBefore+1, nbrLinesAfter);
    }

    public int readAddressInfoFile() {
        int nbrLines = 0;
        try (
                BufferedReader br = Files.newBufferedReader(Paths.get("addressinfo.txt"))) {
            while (br.readLine() != null) {
                nbrLines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("nbrlines : " +nbrLines);
        return nbrLines;
    }
    @Ignore
    public void noIdeaYetWhatWeAreGoingToTest() {
        //arrange
        //act
        //assert

    }

}
