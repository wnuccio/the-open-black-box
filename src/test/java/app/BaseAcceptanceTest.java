package app;

import org.junit.jupiter.api.BeforeEach;

public abstract class BaseAcceptanceTest {

    @BeforeEach
    final void init() {
        ApplicationBuilderForTest builder = getApplicationBuilder();
        TestConfiguration configuration = new TestConfiguration(builder);
        ApplicationRunner application = configuration.applicationRunner();
        application.runApplication();

        ApplicationDriver driver = configuration.applicationDriver();
        setup(driver);
    }

    protected ApplicationBuilderForTest getApplicationBuilder() {
        return new ApplicationBuilderForTest();
    }

    protected abstract void setup(ApplicationDriver driver);
}
