package stringCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOuputSystem {

    private BufferedReader br;

    public boolean OuputString() throws IOException {
        String answer = inputString();
        if(!answer.equals("0")){
            System.out.println(answer);
            return true;
        };
        return false;
    }

    private String inputString() throws IOException {
        System.out.print("계산할 값을 입력해주세요(0만 입력시 종료) : ");
        br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

}
