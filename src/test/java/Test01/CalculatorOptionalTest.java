package Test01;

import S01.CalculatorOptional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CalculatorOptionalTest {

    @DisplayName("computeAll 메서드 Test")
    @Test
    public void computeAll() {
        CalculatorOptional calculatorOptional = new CalculatorOptional();
        String data = "2+3-4*1+5/2*4";
        String errorData = "2+3-4*1+5+/2*-4";

        assertThat(calculatorOptional.computeAll(data).equals("12"));
        Assertions.assertThrows(Exception.class,()->calculatorOptional.computeAll(errorData));
    }
}
