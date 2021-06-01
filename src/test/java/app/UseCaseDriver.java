package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCaseDriver {
    private final ApplicationDriver driver;

    public UseCaseDriver(ApplicationDriver driver) {
        this.driver = driver;
    }

    public String addName(String name) {
        return driver.acceptInput("add user " + name);
    }

    public void verifyHelloTo(String output, String name) {
        assertEquals("hello " + name +"!", output);
    }
}
