package S01;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputOutputSystem inputOutputSystem = new InputOutputSystem();
        while (inputOutputSystem.systemStatus()){
            inputOutputSystem.question();
            inputOutputSystem.compute();
        }
    }

}
