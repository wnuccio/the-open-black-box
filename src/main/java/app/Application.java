package app;

public class Application {
    private final InputOutput inputOutput;
    private final Service service;

    public Application(InputOutput inputOutput, Service service) {
        this.inputOutput = inputOutput;
        this.service = service;
    }

    public void run() {
        inputOutput.writeOutputLine("Application Started!");
        while (true) {
            String string = inputOutput.readInputLine();

            String name = extractNameFrom(string);
            inputOutput.writeOutputLine("hello " + name + "!");
        }
    }

    private String extractNameFrom(String string) {
        String[] tokens = string.split(" ");

        if (tokens.length == 3 && string.startsWith("add user")) {
            return tokens[2];
        }

        if (tokens.length == 2 && string.startsWith("add user")) {
            return "user_" + service.getNumber();
        }

        throw new IllegalStateException("bad input: " + string);
    }
}
