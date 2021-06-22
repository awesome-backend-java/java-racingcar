package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputOutputSystemTest {

    @DisplayName("inputString 메서드 입력 확인")
    @Test
    public void test1() {
        InputOutputSystem inputOutputSystem = new InputOutputSystem();
        try {
            String data = "2+2*3";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            inputOutputSystem.inputString();
            assertThat(inputOutputSystem.answer.equals(12));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
