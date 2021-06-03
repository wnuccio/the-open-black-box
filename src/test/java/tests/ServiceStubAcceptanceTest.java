package tests;

import app.ApplicationBuilderForTest;
import app.ApplicationDriver;
import app.BaseAcceptanceTest;
import app.Service;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceStubAcceptanceTest extends BaseAcceptanceTest {

    private ApplicationDriver driver;

    @Override
    protected ApplicationBuilderForTest getApplicationBuilder() {
        return new ApplicationBuilderForTest() {
            @Override
            protected Service getService() {
                return () -> 15;
            }
        };
    }

    @Override
    protected void setup(ApplicationDriver driver) {
        this.driver = driver;
    }

    @Test
    void test_input_without_name() {
        String output = driver.acceptInput("add user");
        assertEquals("hello user_15!", output);
    }
}
