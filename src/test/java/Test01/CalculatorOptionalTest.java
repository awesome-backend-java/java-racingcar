package Test01;

import S01.CalculatorOptional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CalculatorOptionalTest {

    @DisplayName("정상적으로 두개의 유리수 덧셈을 수행한다.")
    @Test
    public void test1() throws Exception {
        CalculatorOptional calculatorOptional = new CalculatorOptional();
        String data = "2.6+3";
        double answer = Double.parseDouble(calculatorOptional.computeAll(data));
        Assertions.assertEquals(answer, 5.6);
    }

    @DisplayName("정상적으로 두개의 유리수 뺄셈을 수행한다.")
    @Test
    public void test2() throws Exception {
        CalculatorOptional calculatorOptional = new CalculatorOptional();
        String data = "2.6-3";
        double answer = 0;
        try {
            answer = Double.parseDouble(calculatorOptional.computeAll(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(answer, -0.4);
    }

    @DisplayName("정상적으로 두개의 유리수 곱셈을 수행한다.")
    @Test
    public void test3() throws Exception {
        CalculatorOptional calculatorOptional = new CalculatorOptional();
        String data = "2.6*3";
        double answer = Double.parseDouble(calculatorOptional.computeAll(data));
        Assertions.assertEquals(answer, 7.8);
    }

    @DisplayName("정상적으로 두개의 유리수 나눗셈을 수행한다.")
    @Test
    public void test4() throws Exception {
        CalculatorOptional calculatorOptional = new CalculatorOptional();
        String data = "15.6/3";
        double answer = Double.parseDouble(calculatorOptional.computeAll(data));
        Assertions.assertEquals(answer, 5.2);
    }

    @DisplayName("정상적으로 세개의 유리수 덧셈을 수행한다.")
    @Test
    public void test5() throws Exception {
        CalculatorOptional calculatorOptional = new CalculatorOptional();
        String data = "2.6+3+5";
        double answer = Double.parseDouble(calculatorOptional.computeAll(data));
        Assertions.assertEquals(answer, 10.6);
    }

    @DisplayName("정상적으로 세개의 유리수 뺄셈을 수행한다.")
    @Test
    public void test6() throws Exception {
        CalculatorOptional calculatorOptional = new CalculatorOptional();
        String data = "2.6-3-5";
        double answer = Double.parseDouble(calculatorOptional.computeAll(data));
        Assertions.assertEquals(answer, -5.4);
    }

    @DisplayName("정상적으로 세개의 유리수 곱셈을 수행한다.")
    @Test
    public void test7() throws Exception {
        CalculatorOptional calculatorOptional = new CalculatorOptional();
        String data = "2.6*3*2";
        double answer = Double.parseDouble(calculatorOptional.computeAll(data));
        Assertions.assertEquals(answer, 15.6);
    }

    @DisplayName("정상적으로 세개의 유리수 나눗셈을 수행한다.")
    @Test
    public void test8() throws Exception {
        CalculatorOptional calculatorOptional = new CalculatorOptional();
        String data = "15.6/3/2";
        double answer = Double.parseDouble(calculatorOptional.computeAll(data));
        Assertions.assertEquals(answer, 2.6);
    }

    @DisplayName("정상적으로 여러개의 부호의 계산을 순서대로 수행한다.")
    @Test
    public void test9() throws Exception {
        CalculatorOptional calculatorOptional = new CalculatorOptional();
        String data = "15.6*3-2+2-2.8/4";
        double answer = Double.parseDouble(calculatorOptional.computeAll(data));
        Assertions.assertEquals(answer, 11);
    }

    @DisplayName("., 부호(*,/,+,-), 숫자 이외의 문자는 무시하고 계산한다.")
    @Test
    public void test10() throws Exception {
        CalculatorOptional calculatorOptional = new CalculatorOptional();
        String data = "(15.6*3((-2+?sjelf2-2ㄴ어ㅣㅏㄹ더.8%^&$/4";
        double answer = Double.parseDouble(calculatorOptional.computeAll(data));
        Assertions.assertEquals(answer, 11);
    }

    @DisplayName("계산할 부호가 연속으로 나올시 오류를 출력한다.")
    @Test
    public void test11() {
        CalculatorOptional calculatorOptional = new CalculatorOptional();
        String errorData = "2+3-4*1+5+/2*-4";

        Assertions.assertThrows(Exception.class, () -> calculatorOptional.computeAll(errorData));
    }

    @DisplayName("소수점이 연속으로 나올시 오류를 출력한다.")
    @Test
    public void test12() {
        CalculatorOptional calculatorOptional = new CalculatorOptional();
        String errorData = "2+3-4*1+5+/2..4";

        Assertions.assertThrows(Exception.class, () -> calculatorOptional.computeAll(errorData));
    }


}
