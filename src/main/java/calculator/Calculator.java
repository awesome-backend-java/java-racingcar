package calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import utils.Utils;

public class Calculator {
	
	public static Map<String, OperatorType> operatorMap = new HashMap<>();
	
	static {
		operatorMap.put("+", OperatorType.SUM);
		operatorMap.put("-", OperatorType.SUBTRACT);
		operatorMap.put("*", OperatorType.MULTIPLY);
		operatorMap.put("/", OperatorType.DIVIDE);
	}
	private boolean isOperator(String value) {
		if(operatorMap.containsKey(value)){
			return true;
		}
		return false;
	}

	public int solve(String input) {
		Utils utils = new Utils();
		List<String> operators = Arrays.stream(utils.splitBySpace(input))
			.filter(this::isOperator)
			.collect(Collectors.toList());
		List<Integer> numbers = Arrays.stream(utils.splitBySpace(input))
			.filter(s -> !isOperator(s))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		return calculateAll(operators, numbers);
	}

	public int calculateAll(List<String> operators, List<Integer> numbers) {
		int value = numbers.get(0);
		for(int i = 0; i < operators.size(); i++){
			String operate = operators.get(i);
			value = OperatorType.calculate(value, numbers.get(i+1), operate);
		}
		return value;
	}
}
