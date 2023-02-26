package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoffeeOrderTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testOrderEspresso() {
        //act
        String input = "1\n"; // simulate user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // redirect System.in to the simulated input

        //arrange
        CoffeeOrder.main(new String[]{}); // run the main method

        //assert
        String expectedOutput = "Thank you, your Espresso Drink is being prepared.";
        assertTrue(systemOut().contains(expectedOutput), "Output does not contain expected confirmation message");

        expectedOutput = "Your Espresso Drink contains: 1 dose(s) of Espresso, Enjoy your drink!";
        assertTrue(systemOut().contains(expectedOutput), "Output does not contain expected recipe message");
    }

    @Test
    public void testInvalidCoffeeType() {
        //act
        String input = "8\n"; // simulate user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // redirect System.in to the simulated input
        //assert
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            CoffeeOrder.main(new String[]{});
            ;
        });
    }

    // helper method to get System.out as a String
    private String systemOut() {
        return outContent.toString().replaceAll("\r\n", "\n"); // normalize line endings
    }
}
