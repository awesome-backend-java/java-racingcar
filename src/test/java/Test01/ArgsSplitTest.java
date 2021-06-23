package Test01;

import S01.ArgsSplit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ArgsSplitTest {

    @DisplayName("계산 부호를 제외한 나머지 문자들은 무시한다.")
    @Test
    public void divide(){
        ArgsSplit argsSplit = new ArgsSplit();
        String data = "12+2)_*3-2+(2+3)*5";

        assertThat(argsSplit.divide(data).equals(275));
    }
}
