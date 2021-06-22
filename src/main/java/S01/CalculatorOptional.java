package S01;

import S01.Calculator.*;

import java.util.HashMap;

public class CalculatorOptional {
    /*
        CalculatorOptional Class
        ver 1.0
        2020.06.22
     */
    private String[] expression;                // 표현식
    private double answer;                      // 정답
    private final double standardDecimal = 0.1; // 소수점 표현
    private final ArgsSplit argsSplit;          // 숫자, 부호 구별
    private final HashMap<String,Calculator> calculatorHashMap; // 계산

    // ArgsSplit,HashMap class 초기화 설정
    public CalculatorOptional() {
        argsSplit = new ArgsSplit();
        calculatorHashMap = new HashMap<>();
        calculatorHashMap.put("+",new PlusCalculator());
        calculatorHashMap.put("-",new MinusCalculator());
        calculatorHashMap.put("*",new MultiplyCalculator());
        calculatorHashMap.put("/",new DivideCalculator());
    }
    // 입력된정보 숫자와,부호 나눠서 앞에서부터 세개씩 계산
    public String computeAll(String args){
        expression = argsSplit.divide(args); // 숫자와 부호 String[] 으로 나누기
        answer = convert(expression[0]);    // 처음 숫자 정보 입력
        for (int i = 1; i < expression.length; i += 2) {
            answer = compute(i);
        }
        return String.valueOf(answer);
    }
    // 부호에 따른 계산
    private double compute(int i){
        Calculator calculator = calculatorHashMap.get(expression[i]); // +,-,*,/ 만 허용
        double x = answer;
        double y = convert(expression[i+1]);
        return calculator.compute(x,y);
    }
    // double형 소수점 변환
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
