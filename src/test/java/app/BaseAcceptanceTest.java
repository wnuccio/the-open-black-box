package app;

import org.junit.jupiter.api.BeforeEach;

public abstract class BaseAcceptanceTest {

    @BeforeEach
    final void init() {
        TestConfiguration configuration = new TestConfiguration();
        ApplicationRunner application = configuration.applicationRunner();
        application.runApplication();

        ApplicationDriver driver = configuration.applicationDriver();
        setup(driver);
    }

    protected abstract void setup(ApplicationDriver driver);
}
