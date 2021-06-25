package S01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutputSystem {

    private static final String endCalculator = "0"; // 게임종료

    private final CalculatorOptional calculatorOptional;
    private final BufferedReader bufferedReader;
    private String answer;
    private String expression;

    public InputOutputSystem() {
        calculatorOptional = new CalculatorOptional();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        expression = "";
    }

    public void question() throws IOException {
        expression = print().readLine();
    }

    public void compute() {
        try {
            answer = calculatorOptional.computeAll(expression);
            output(answer);
        } catch (Exception error) {
            System.out.println(expression);
            System.out.println("-------- 잘못된 입력입니다. 다시 입력해주세요 --------");
        }
    }

    // 입력한 정보가 0일때 종료
    public boolean systemStatus() {
        return !expression.equals(endCalculator);
    }

    private void output(String answer) {
        System.out.println(answer);
    }

    private BufferedReader print() {
        System.out.print("계산할 값을 입력해주세요(0만 입력시 종료) : ");
        return bufferedReader;
    }

    public String getAnswer() {
        return answer;
    }
}
