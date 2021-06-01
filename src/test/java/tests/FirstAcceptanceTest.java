package tests;

import app.ApplicationBuilder;
import app.ApplicationRunner;
import app.InputOutput;
import app.SharedMemory;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstAcceptanceTest {

    @Test
    void first_acceptance_test() {
        SharedMemory sharedMemory = new SharedMemory();

        ApplicationBuilder builderForTest = new ApplicationBuilder() {
            @Override
            protected InputOutput getInputOutput() {
                return sharedMemory;
            }
        };

        ApplicationRunner runner = new ApplicationRunner(builderForTest);

        runner.runApplication();

        sharedMemory.writeInputByTest("add user Pippo");
        String output;
        sharedMemory.readOutputByTest(1, TimeUnit.SECONDS); // first response
        output = sharedMemory.readOutputByTest(1, TimeUnit.SECONDS);

        assertEquals("hello Pippo!", output);
    }
}
