package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
	public String[] splitStr(String calStr){
		return calStr.split(" ");
	}

	public boolean isOp(String op){
		if("+".equals(op) || "-".equals(op) || "*".equals(op) || "/".equals(op)){
			return true;
		}
		return false;
	}

	public int partCalculate(int x, String op, int y){
		if("+".equals(op)){
			return sum(x, y);
		}
		else if("-".equals(op)){
			return sub(x, y);
		}
		else if("*".equals(op)){
			return mul(x, y);
		}
		return div(x, y);
	}

	public int opNumSplitSave(String[] calStr){
		List<String> opList = Arrays.stream(calStr)
			.filter(s -> isOp(s))
			.collect(Collectors.toList());
		List<Integer> numList = Arrays.stream(calStr)
			.filter(s -> !isOp(s))
			.map(s -> Integer.parseInt(s))
			.collect(Collectors.toList());
		return solve(opList, numList);
	}

	public int solve(List<String> opList, List<Integer> numList){
		int val = numList.get(0);
		for(int i = 0; i < opList.size(); i++){
			String op = opList.get(i);
			val = partCalculate(val, op, numList.get(i+1));
		}
		return val;
	}

	public int sum(int num1, int num2){
		return num1 + num2;
	}

	public int sub(int num1, int num2){
		return num1 - num2;
	}

	public int mul(int num1, int num2){
		return num1 * num2;
	}

	public int div (int num1, int num2) throws ArithmeticException {
		return num1 / num2;
	}
}
