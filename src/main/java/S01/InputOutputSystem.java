package S01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutputSystem {

    private final CalculatorOptional calculatorOptional;
    private final String endCalculator; // 게임종료
    private String answer;

    public InputOutputSystem() {
        calculatorOptional = new CalculatorOptional();
        endCalculator = "0";
    }
    //입력정보를 받고 받은 정보 CalculatorOptional 클래스로 전달
    public boolean input() throws IOException {
        System.out.print("계산할 값을 입력해주세요(0만 입력시 종료) : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = calculatorOptional.computeAll(br.readLine());
            return systemStatus();
        } catch (Exception error) {
            System.out.println("-------- 잘못된 입력입니다. 다시 입력해주세요 --------");
            return true;
        }
    }
    // 입력한 정보가 0일때 종료
    private boolean systemStatus() {
        if (answer.equals(endCalculator)) {
            return false;
        }
        output(answer);
        return true;
    }
    private void output(String answer) {
        System.out.println(answer);
    }
    public String getAnswer() {
        return answer;
    }
}
