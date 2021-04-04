import java.util.Scanner;

import calculator.Calculator;
import utils.Utils;

public class CalculatorApplication {
	public static void main(String[] args) {

		/* input value */
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println("calStr = " + input);
		Calculator calculator = new Calculator();

		/* split String */
		int result = calculator.solve(input);
		System.out.println("result = " + result);
	}
}
