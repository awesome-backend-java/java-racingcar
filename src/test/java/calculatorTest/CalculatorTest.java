package calculatorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.Calculator;
import calculator.OperatorType;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	private Calculator calculator;
	
	@BeforeEach
	public void setup(){
		calculator = new Calculator();
	}
	
	@Test
	public void sum_test(){
		int result = OperatorType.calculate(10, 100, "+");
		assertEquals(result, 110);
	}

	@Test
	public void subtract_test(){
		int result = OperatorType.calculate(10, 2, "-");
		assertEquals(result, 8);
	}

	@Test
	public void multiply_test(){
		int result = OperatorType.calculate(10, 10, "*");
		assertEquals(result, 100);
	}

	@Test
	public void divide_test(){
		int result = OperatorType.calculate(10, 2, "/");
		assertEquals(result, 5);
	}
	
	@Test
	public void solve_test(){
		List<String> operatorTest = new ArrayList<>();
		List<Integer> numTest = new ArrayList<>();
		operatorTest.add("+");
		operatorTest.add("-");
		numTest.add(5);
		numTest.add(10);
		numTest.add(6);
		int result = calculator.calculateAll(operatorTest,numTest);
		assertEquals(result, 9);
	}

	@Test
	public void calculate_test(){
		int result = calculator.solve("1 + 2 + 3 * 4 / 5");
		assertEquals(result, 4);
	}

	@Test
	public void calculate_test2(){
		int result = calculator.solve("0 + 0 + 0 * 00");
		assertEquals(result, 0);
	}
}
