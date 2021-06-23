package Test01;

import S01.InputOutputSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputOutputSystemTest {

    @DisplayName("정상적인 덧셈으로 계산하여 출력한다. 2+2+2 결과 6")
    @Test
    public void test1() {
        InputOutputSystem inputOutputSystem = new InputOutputSystem();
        try {
            String data = "2+2+2";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            inputOutputSystem.input();
            double answer = Double.parseDouble(inputOutputSystem.getAnswer());
            Assertions.assertEquals(answer,6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
