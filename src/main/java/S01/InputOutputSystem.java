package S01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutputSystem {

    private final CalculatorOptional calculatorOptional;
    private final String endCalculator; // 게임종료
    private final BufferedReader bufferedReader;
    private String answer;
    private String expression;

    public InputOutputSystem() {
        calculatorOptional = new CalculatorOptional();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        endCalculator = "0";
        expression = "";
    }

    //입력정보를 받고 받은 정보 CalculatorOptional 클래스로 전달
    public void input() throws IOException {
        expression = print().readLine();
        try {
            answer = calculatorOptional.computeAll(expression);
            output(answer);
        } catch (Exception error) {
            System.out.println("-------- 잘못된 입력입니다. 다시 입력해주세요 --------");
        }
    }

    // 입력한 정보가 0일때 종료
    public boolean systemStatus() {
        return !expression.equals(endCalculator);
    }

    private BufferedReader print() {
        System.out.print("계산할 값을 입력해주세요(0만 입력시 종료) : ");
        return bufferedReader;
    }

    private void output(String answer) {
        System.out.println(answer);
    }

    public String getAnswer() {
        return answer;
    }
}
