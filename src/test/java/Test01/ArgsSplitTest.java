package Test01;

import S01.ArgsSplit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ArgsSplitTest {

    @DisplayName("divide 메서드 Test")
    @Test
    public void divide(){
        ArgsSplit argsSplit = new ArgsSplit();
        String data = "12+2)_*3-2+(2+3)*5";

        assertThat(argsSplit.divide(data).equals(275));
    }
}
