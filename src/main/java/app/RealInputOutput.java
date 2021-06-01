package app;

import java.util.Scanner;

class RealInputOutput implements InputOutput {
    @Override
    public String readInputLine() {
        return new Scanner(System.in).nextLine();
    }

    @Override
    public void writeOutputLine(String line) {
        System.out.println(line);
    }
}
