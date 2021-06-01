package app;

import static java.lang.String.format;

public class ApplicationRunner {

    private final ApplicationBuilder builder;
    private final ApplicationDriver driver;

    public ApplicationRunner(ApplicationBuilder builder, ApplicationDriver driver) {
        this.builder = builder;
        this.driver = driver;
    }

    public ApplicationRunner(ApplicationBuilder builder) {
        this(builder, null);
    }

    public void runApplication() {
        Thread thread = new Thread(() -> {
            Main.applicationBuilder = builder;
            Main.main(new String[]{});
        });

        thread.start();
        waitForApplicationResponse();
    }

    private void waitForApplicationResponse() {
        if (driver == null) return;

        String output = driver.readOutput();

        final String FIRST_RESPONSE = "Application Started!";
        if ( ! FIRST_RESPONSE.equals(output)) throw new IllegalStateException(
                format("run application failed - received output '%s' while expecting '%s'", output, FIRST_RESPONSE));
    }
}
