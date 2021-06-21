package stringCalculator;

public class CalculatorOptional {

    private String[] expression;
    private double answer;
    private final Calculator calculator;
    private final ArgsSplit argsSplit;

    public CalculatorOptional(){
        calculator = new Calculator();
        argsSplit = new ArgsSplit();
    }
    public String compute(String args){
        expression = argsSplit.divide(args);
        answer = convert(expression[0]);

        for(int i=1; i<expression.length; i+=2){
            answer = calculator.compute(answer,expression[i], convert(expression[i+1]));
        }
        return String.valueOf(answer);
    }
    private double convert(String s){
        int natural = s.indexOf('.');
        if(natural<0){
            return Double.parseDouble(s);
        }
        int decimal = s.length()-natural-1;
        String expression = s.replace(".","");
        return Long.parseLong(expression) * Math.pow(0.1,decimal);
    }
}
