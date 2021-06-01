package tests;

import app.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceStubAcceptanceTest {

    private static class BuilderWithServiceStub extends ApplicationBuilderForTest {
        @Override
        protected Service getService() { return () -> 15; }
    }

    @Test
    void test_input_without_name() {
        TestConfiguration configuration = new TestConfiguration(new BuilderWithServiceStub());
        ApplicationRunner application = configuration.applicationRunner();
        application.runApplication();
        ApplicationDriver driver = configuration.applicationDriver();

        String output = driver.acceptInput("add user");
        assertEquals("hello user_15!", output);
    }
}
