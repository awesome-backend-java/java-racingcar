import java.util.Scanner;

import calculator.Calculator;

public class CalApp {
	public static void main(String[] args) {

		/* input value */
		Scanner sc = new Scanner(System.in);
		String calStr = sc.nextLine();
		System.out.println("calStr = " + calStr);
		Calculator calculator = new Calculator();

		/* split String */
		String[] splitCalStr = calculator.splitStr(calStr);
		int result = calculator.opNumSplitSave(splitCalStr);
		System.out.println("result = " + result);
	}
}
