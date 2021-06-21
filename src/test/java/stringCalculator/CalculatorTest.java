package stringCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calculator;

    public CalculatorTest(){
        calculator = new Calculator();
    }

    @DisplayName("compute 메서드 Test")
    @Test
    public void compute(){
        Assertions.assertEquals(calculator.compute(2,"+",2),4);
        Assertions.assertEquals(calculator.compute(2,"-",2),0);
        Assertions.assertEquals(calculator.compute(2,"*",3),6);
        Assertions.assertEquals(calculator.compute(2,"/",2),1);
    }

    @DisplayName("덧셈 메서드 test")
    @Test
    public void add(){
        Assertions.assertEquals(calculator.sum(12,24),36);
    }

    @DisplayName("뺄셈 메서드 test")
    @Test
    public void sub(){
        Assertions.assertEquals(calculator.sub(2,2),0);
    }

    @DisplayName("곱셈 메서드 test")
    @Test
    public void mul(){
        Assertions.assertEquals(calculator.mul(2,3),6);
    }

    @DisplayName("나눗셈 메서드 test")
    @Test
    public void div(){
        Assertions.assertEquals(calculator.div(2,2),1);
    }
}
