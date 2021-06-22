package S01;

import S01.Calculator.*;

import java.util.HashMap;

public class CalculatorOptional {

    private String[] expression;
    private double answer;
    private final double standardDecimal = 0.1;
    private final ArgsSplit argsSplit;
    private final HashMap<String,Calculator> calculatorHashMap;

    public CalculatorOptional() {
        argsSplit = new ArgsSplit();
        calculatorHashMap = new HashMap<>();
        calculatorHashMap.put("+",new PlusCalculator());
        calculatorHashMap.put("-",new MinusCalculator());
        calculatorHashMap.put("*",new MultiplyCalculator());
        calculatorHashMap.put("/",new DivideCalculator());
    }
    public String computeAll(String args) throws Exception{
        expression = argsSplit.divide(args);
        answer = convert(expression[0]);
        for (int i = 1; i < expression.length; i += 2) {
            answer = compute(i);
        }
        return String.valueOf(answer);
    }
    private double compute(int i){
        Calculator calculator = calculatorHashMap.get(expression[i]);
        double x = answer;
        double y = convert(expression[i+1]);
        return calculator.compute(x,y);
    }
    private double convert(String s) {
        int natural = s.indexOf('.');
        int decimalCount = s.length() - natural - 1;
        if (natural < 0) {
            return Double.parseDouble(s);
        }
        String expression = s.replace(".", "");
        return Long.parseLong(expression) * Math.pow(standardDecimal, decimalCount);
    }
}
