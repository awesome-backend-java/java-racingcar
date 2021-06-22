package S01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InputOutputSystem {

    private final CalculatorOptional calculatorOptional;
    public String answer;

    public InputOutputSystem(){
        calculatorOptional = new CalculatorOptional();
    }
    public boolean inputString() throws IOException {
        System.out.print("계산할 값을 입력해주세요(0만 입력시 종료) : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = calculatorOptional.computeAll(br.readLine());
            return SystemStatus();
        }catch (Exception error){
            System.out.println("-------- 잘못된 입력입니다. 다시 입력해주세요 --------");
            return true;
        }
    }
    private void OutputString(String answer) {
        System.out.println(answer);
    }
    private boolean SystemStatus() {
        if (!answer.equals("0")) {
            OutputString(answer);
            return true;
        }
        return false;
    }

}
