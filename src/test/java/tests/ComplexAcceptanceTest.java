package tests;

import app.ApplicationDriver;
import app.BaseAcceptanceTest;
import app.UseCaseDriver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplexAcceptanceTest extends BaseAcceptanceTest {

    private ApplicationDriver driver;

    @Override
    protected void setup(ApplicationDriver driver) {
        this.driver = driver;
    }

    @Test
    void test_single_input() {
        String output = driver.acceptInput("add user Pippo");
        assertEquals("hello Pippo!", output);
    }

    @Test
    void test_sequence_of_inputs() {
        String output;

        output = driver.acceptInput("add user Pluto");
        assertEquals("hello Pluto!", output);

        output = driver.acceptInput("add user Paperino");
        assertEquals("hello Paperino!", output);
    }

    @Test
    void add_name_use_case() {
        UseCaseDriver addNameDriver = new UseCaseDriver(driver);

        String output = addNameDriver.addName("Pluto");

        addNameDriver.verifyHelloTo(output, "Pluto");
    }
}
