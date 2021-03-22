package calculatorTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calculator.Calculator;

public class CalculatorTest {
	Calculator calculator;

	@BeforeEach
	public void setup(){
		calculator = new Calculator();
	}

	@Test
	public void sum_test(){
		int result = calculator.sum(10, 100);
		assertEquals(result, 110);
	}

	@Test
	public void sub_test(){
		int result = calculator.sub(10, 2);
		assertEquals(result, 8);
	}

	@Test
	public void mul_test(){
		int result = calculator.mul(10, 10);
		assertEquals(result, 100);
	}

	@Test
	public void div_test(){
		int result = calculator.div(10, 2);
		assertEquals(result, 5);
	}

	@Test
	public void div_fail_test(){
		assertThrows(ArithmeticException.class, () -> {
			calculator.div(10, 0);
		});
	}

	@Test
	public void solve_test(){
		List<String> opTest = new ArrayList<>();
		List<Integer> numTest = new ArrayList<>();
		opTest.add("+");
		opTest.add("-");
		numTest.add(5);
		numTest.add(10);
		numTest.add(6);
		int result = calculator.solve(opTest,numTest);
		assertEquals(result, 9);
	}

	@Test
	public void calculate_Test(){
		//split String
		String[] splitCalStr = calculator.splitStr("1 + 2 + 3 * 4 / 5");
		int result = calculator.opNumSplitSave(splitCalStr);
		assertEquals(result, 4);
	}

	@Test
	public void calculate_Test2(){
		//split String
		String[] splitCalStr = calculator.splitStr("0 + 0 + 0 * 00");
		int result = calculator.opNumSplitSave(splitCalStr);
		assertEquals(result, 0);
	}
}
