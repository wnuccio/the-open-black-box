package app;

public class TestConfiguration {

    private final ApplicationDriver driver;
    private final ApplicationRunner applicationRunner;

    public TestConfiguration() {
        this(new ApplicationBuilderForTest());
    }

    public TestConfiguration(ApplicationBuilderForTest builder) {
        SharedMemory sharedMemory = builder.getInputOutput();
        driver = new ApplicationDriver(sharedMemory);
        applicationRunner = new ApplicationRunner(builder, driver);
    }

    public ApplicationRunner applicationRunner() {
        return applicationRunner;
    }

    public ApplicationDriver applicationDriver() {
        return driver;
    }
}
