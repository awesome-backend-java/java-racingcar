package Test01;

import S01.CalculatorOptional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CalculatorOptionalTest {

    @DisplayName("정상적으로 소수점 덧셈을 수행한다. 2.6+3 = 5.6")
    @Test
    public void test1() {
        CalculatorOptional calculatorOptional = new CalculatorOptional();
        String data = "2.6+3";
        double answer = Double.parseDouble(calculatorOptional.computeAll(data));
        Assertions.assertEquals(answer,5.6);
    }
    @DisplayName("계산할 부호가 연속으로 나올시 오류를 출력한다.")
    @Test
    public void test2() {
        CalculatorOptional calculatorOptional = new CalculatorOptional();
        String errorData = "2+3-4*1+5+/2*-4";

        Assertions.assertThrows(Exception.class,()->calculatorOptional.computeAll(errorData));
    }
}
