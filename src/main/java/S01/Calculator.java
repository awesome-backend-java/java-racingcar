package S01;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    private final Map<String, BiFunction<Double, Double, Double>> calculatorMap;

    public Calculator() {
        calculatorMap = new HashMap<>();
        calculatorMap.put("+", (num1, num2) -> num1 + num2);
        calculatorMap.put("-", (num1, num2) -> num1 - num2);
        calculatorMap.put("*", (num1, num2) -> num1 * num2);
        calculatorMap.put("/", (num1, num2) -> num1 / num2);
    }

    // 부호에 따른 계산
    public double compute(double frontNumber, String operation, double backNumber) {
        return calculatorMap.get(operation).apply(frontNumber, backNumber);
    }
}
