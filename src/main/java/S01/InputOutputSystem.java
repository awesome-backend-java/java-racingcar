package S01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutputSystem {
    /*
        InputOutputSystem Class
        ver 1.0
        2020.06.22
     */
    private final CalculatorOptional calculatorOptional;
    public String answer;

    // CalculatorOptional 클래스 초기화 설정
    public InputOutputSystem(){
        calculatorOptional = new CalculatorOptional();
    }
    //입력정보를 받고 받은 정보 CalculatorOptional 클래스로 전달
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
    // 정답 출력하기
    private void OutputString(String answer) {
        System.out.println(answer);
    }
    // 입력한 정보가 0일때 종료
    private boolean SystemStatus() {
        if (!answer.equals("0")) {
            OutputString(answer);
            return true;
        }
        return false;
    }

}
