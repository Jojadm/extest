package be.abis.exercise.ut;

import be.abis.exercise.model.Address;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestAddress {

    private static Address addressUnderTest;

    @BeforeClass
    public static void Setup() {
        addressUnderTest = new Address("Mutsereelstraat","27", "9310", "Aalst", "België", "BE");
    }

    @Test
    public void belgianZipCodeShouldBeNumeric() {
        //arrange
        //act
        //assert
        assertTrue(addressUnderTest.checkBelgianZipCode());
    }

    @Test
    public void writingAddressToFile() {
        //arrange
        int nbrLinesBefore = 0, nbrLinesAfter = 0;
        //act
        //read file & count lines
        try (
                BufferedReader br = Files.newBufferedReader(Paths.get("addressinfo.txt"))) {
            while (br.readLine() != null) {
                nbrLinesBefore++;
            }
        } catch (NoSuchFileException nsfe) {
            nbrLinesBefore = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        // add line
        addressUnderTest.writeAddress();
        // read files & count lines
        try (
                BufferedReader br = Files.newBufferedReader(Paths.get("addressinfo.txt"))) {
            while (br.readLine() != null) {
                nbrLinesAfter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Assert
        System.out.println("Aantal lijnen : " +nbrLinesBefore + " - " +nbrLinesAfter);
        assertEquals(nbrLinesBefore+1, nbrLinesAfter);

    }
}
