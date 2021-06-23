package S01;

import java.util.HashMap;
import java.util.function.BiFunction;

public class Calculator {

    private final HashMap<String, BiFunction<Double, Double, Double>> calculatorHashMap;

    public Calculator() {
        calculatorHashMap = new HashMap<>();
        calculatorHashMap.put("+", (num1, num2) -> num1 + num2);
        calculatorHashMap.put("-", (num1, num2) -> num1 - num2);
        calculatorHashMap.put("*", (num1, num2) -> num1 * num2);
        calculatorHashMap.put("/", (num1, num2) -> num1 / num2);
    }

    // 부호에 따른 계산
    public double compute(double x, String op, double y) {
        return calculatorHashMap.get(op).apply(x, y);
    }
}
