package app;

public class ApplicationBuilderForTest extends ApplicationBuilder {
    private final SharedMemory sharedMemory;

    public ApplicationBuilderForTest() {
        this.sharedMemory = new SharedMemory();
    }

    @Override
    protected SharedMemory getInputOutput() {
        return sharedMemory;
    }
}
