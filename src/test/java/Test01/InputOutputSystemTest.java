package Test01;

import S01.InputOutputSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class InputOutputSystemTest {

    @DisplayName("정상적인 덧셈으로 계산하여 출력한다. 2+2+2 결과 6")
    @Test
    public void test1() {
        String data = "2+2+2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputOutputSystem inputOutputSystem = new InputOutputSystem();
        try {
            inputOutputSystem.question();
            inputOutputSystem.compute();
            double answer = Double.parseDouble(inputOutputSystem.getAnswer());
            Assertions.assertEquals(answer, 6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("정상적인 뺄셈으로 계산하여 출력한다.")
    @Test
    public void test2() {
        String data = "10-2-2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputOutputSystem inputOutputSystem = new InputOutputSystem();
        try {
            inputOutputSystem.question();
            inputOutputSystem.compute();
            double answer = Double.parseDouble(inputOutputSystem.getAnswer());
            Assertions.assertEquals(answer, 6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("정상적인 곱셈으로 계산하여 출력한다.")
    @Test
    public void test3() {
        String data = "10*2*2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputOutputSystem inputOutputSystem = new InputOutputSystem();
        try {
            inputOutputSystem.question();
            inputOutputSystem.compute();
            double answer = Double.parseDouble(inputOutputSystem.getAnswer());
            Assertions.assertEquals(answer, 40);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("정상적인 나눗셈으로 계산하여 출력한다.")
    @Test
    public void test4() {
        String data = "10/2/2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputOutputSystem inputOutputSystem = new InputOutputSystem();
        try {
            inputOutputSystem.question();
            inputOutputSystem.compute();
            double answer = Double.parseDouble(inputOutputSystem.getAnswer());
            Assertions.assertEquals(answer, 2.5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("정상적인 여러가지 연산을 계산한다.")
    @Test
    public void test5() {
        String data = "10+2-2/2*6+5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputOutputSystem inputOutputSystem = new InputOutputSystem();
        try {
            inputOutputSystem.question();
            inputOutputSystem.compute();
            double answer = Double.parseDouble(inputOutputSystem.getAnswer());
            Assertions.assertEquals(answer, 35);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("0을 입력시 0을 반환한다.")
    @Test
    public void test6() {
        String data = "0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputOutputSystem inputOutputSystem = new InputOutputSystem();
        try {
            inputOutputSystem.question();
            inputOutputSystem.compute();
            double answer = Double.parseDouble(inputOutputSystem.getAnswer());
            Assertions.assertEquals(answer, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
