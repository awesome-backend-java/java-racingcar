package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorType {
	SUM("+", (num1, num2) -> num1 + num2),
	SUBTRACT("-", (num1, num2) -> num1 - num2),
	MULTIPLY("*", (num1, num2) -> num1 * num2),
	DIVIDE("/", (num1, num2) -> num1 / num2);
	
	private String operator;
	private BiFunction<Integer, Integer, Integer> operatorValue;
	
	OperatorType(String operator, BiFunction<Integer, Integer, Integer> operatorValue) {
		this.operator = operator;
		this.operatorValue = operatorValue;
	}
	
	public static OperatorType getOperatorType(String operator) {
		return Arrays.stream(values())
				.filter(o -> o.operator.equals(operator))
				.findFirst()
				.orElseThrow(()-> new IllegalArgumentException("The operator does not exit"));
	}
	
	public static Integer calculate(int num1, int num2, String operator){
		return getOperatorType(operator).operatorValue.apply(num1, num2);
	}
}
