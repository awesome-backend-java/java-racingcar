package Test01;

import S01.SentenceSplit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SentenceSplitTest {

    private int count;

    @DisplayName("계산 부호를 제외한 나머지 문자들은 무시한다.")
    @Test
    public void test1() throws Exception {
        SentenceSplit argsSplit = new SentenceSplit();
        String data = "12+2)_*3-2+(2+3)*5";
        String[] answer = "12 + 2 * 3 - 2 + 2 + 3 * 5".split(" ");
        count=0;

        for(String i : argsSplit.divide(data)){
            Assertions.assertEquals(i,answer[count]);
            count++;
        }
    }

    @DisplayName("+가 두개 연속으로 들어오면 에러를 반환한다.")
    @Test
    public void test2(){
        SentenceSplit argsSplit = new SentenceSplit();
        String data = "12++2";


    }
}
