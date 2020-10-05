package be.abis.exercise.ut2;

import be.abis.exercise.model.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAddress {

    private static Address addressUnderTest;
    private static File file;

    @BeforeEach
    public void beforeEachTest() {
        addressUnderTest = new Address("Mutsereelstraat","27", "9310", "Aalst", "België", "BE");
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

    @Test
    public void addressFileIOExceptionReadOnly()  {
        //arrange
        file.setReadOnly();
        //act & Assert
        Assertions.assertThrows(IOException.class, () -> {
            addressUnderTest.writeAddress();
        });
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
    @Disabled
    public void noIdeaYetWhatWeAreGoingToTest() {
        //arrange
        //act
        //assert

    }

}
