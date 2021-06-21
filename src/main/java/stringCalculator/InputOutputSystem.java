package stringCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutputSystem {

    private static String answer;
    private BufferedReader br;

    public boolean inputString() throws IOException {
        System.out.print("계산할 값을 입력해주세요(0만 입력시 종료) : ");
        br = new BufferedReader(new InputStreamReader(System.in));
        answer = br.readLine();
        return SystemStatus();
    }


    private void OutputString(String answer){
        System.out.println(answer);
    }

    private boolean SystemStatus() throws IOException {
        if(!answer.equals("0")){
            OutputString(answer);
            return true;
        };
        return false;
    }

}
