package app;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class SharedMemory implements InputOutput {
    private final BlockingQueue<String> inputQueue;
    private final BlockingQueue<String> outputQueue;

    public SharedMemory() {
        inputQueue = new LinkedBlockingDeque<>();
        outputQueue = new LinkedBlockingDeque<>();
    }

    public void writeInputByTest(String line) {
        try {
            inputQueue.put(line);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String readInputLine() {
        try {
            return inputQueue.take();
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void writeOutputLine(String line) {
        try {
            this.outputQueue.put(line);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        System.out.println(line);
    }

    public String readOutputByTest(int timeout, TimeUnit timeUnit) {
        try {
            String output = outputQueue.poll(timeout, timeUnit);
            if (output == null) throw new IllegalStateException("Timeout expired with no output");
            return output;
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
