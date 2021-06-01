package app;

public class Main {
    static ApplicationBuilder applicationBuilder = null;

    public static void main(String[] args) {
        ApplicationBuilder builder = applicationBuilder != null ? applicationBuilder : new ApplicationBuilder();
        Application app = builder.build();
        app.run();
    }

}
