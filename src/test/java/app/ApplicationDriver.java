package app;

import java.util.concurrent.TimeUnit;

public class ApplicationDriver {
    private final SharedMemory sharedMemory;

    public ApplicationDriver(SharedMemory sharedMemory) {
        this.sharedMemory = sharedMemory;
    }

    public String readOutput() {
        return sharedMemory.readOutputByTest(5, TimeUnit.MILLISECONDS);
    }

    public String acceptInput(String inputLine) {
        sharedMemory.writeInputByTest(inputLine);
        return readOutput();
    }
}
