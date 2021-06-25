package Test01;

import S01.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calculator;
    private double frontName;
    private String operation;
    private double backName;

    public CalculatorTest() {
        this.calculator = new Calculator();
    }

    @Test
    @DisplayName("정해진 부호말고 다른 부호가 들어와 에러가 생긴다.")
    public void errorCheck() {
        Assertions.assertThrows(Exception.class, () -> calculator.compute(2.0, ".", 3.0));
    }

    @Test
    @DisplayName("정상적으로 두 유리수를 더한다.")
    public void addTwoDecimal() {
        frontName = 2.5;
        operation = "+";
        backName = 5.5;
        Assertions.assertEquals(calculator.compute(frontName, operation, backName), 8);
    }

    @Test
    @DisplayName("정상적으로 두 유리수를 뺀다.")
    public void minusTwoDecimal() {
        frontName = 6.3;
        operation = "-";
        backName = 2.7;
        Assertions.assertEquals(calculator.compute(frontName, operation, backName), 3.6);
    }

    @Test
    @DisplayName("정상적으로 두 유리수를 곱한다.")
    public void mulTwoDecimal() {
        frontName = 2.4;
        operation = "*";
        backName = 5;
        Assertions.assertEquals(calculator.compute(frontName, operation, backName), 12);
    }

    @Test
    @DisplayName("정상적으로 두 유리수를 나눈다.")
    public void divTwoDecimal() {
        frontName = 5.5;
        operation = "/";
        backName = 5;
        Assertions.assertEquals(calculator.compute(frontName, operation, backName), 1.1);
    }

    @Test
    @DisplayName("정상적으로 두 정수를 더한다.")
    public void addTwoNumber() {
        frontName = 2;
        operation = "+";
        backName = 2;
        Assertions.assertEquals(calculator.compute(frontName, operation, backName), 4);
    }

    @Test
    @DisplayName("정상적으로 두 정수를 뺀다.")
    public void minusTwoNumber() {
        frontName = 6;
        operation = "-";
        backName = 2;
        Assertions.assertEquals(calculator.compute(frontName, operation, backName), 4);
    }

    @Test
    @DisplayName("정상적으로 두 정수를 곱한다.")
    public void mulTwoNumber() {
        frontName = 2;
        operation = "*";
        backName = 3;
        Assertions.assertEquals(calculator.compute(frontName, operation, backName), 6);
    }

    @Test
    @DisplayName("정상적으로 두 정수를 나눈다.")
    public void divTwoNumber() {
        frontName = 2;
        operation = "/";
        backName = 2;
        Assertions.assertEquals(calculator.compute(frontName, operation, backName), 1);
    }

}
