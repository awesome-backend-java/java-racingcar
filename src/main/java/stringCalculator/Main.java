package stringCalculator;

import java.io.IOException;

public class Main {

    public static ArgsSplit argsSplit;

    public static void main(String[] args) throws IOException {
        InputOutputSystem inputOutputSystem = new InputOutputSystem();
        argsSplit = new ArgsSplit();
        while (inputOutputSystem.inputString());
    }

}
