package app;

public class ApplicationBuilder {
    final public Application build() {
        return new Application(getInputOutput(), getService());
    }

    protected InputOutput getInputOutput() {
        return new RealInputOutput();
    }

    protected Service getService() { return new RealService(); }

}
