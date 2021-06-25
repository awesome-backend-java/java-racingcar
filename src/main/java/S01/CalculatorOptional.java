package S01;

public class CalculatorOptional {
    private String[] expression;
    private double answer;
    private final double standardDecimal = 0.1;
    private final SentenceSplit argsSplit;
    private final Calculator calculator;

    // ArgsSplit,HashMap class 초기화 설정
    public CalculatorOptional() {
        argsSplit = new SentenceSplit();
        calculator = new Calculator();
    }

    // 입력된정보 숫자와,부호 나눠서 앞에서부터 세개씩 계산
    public String computeAll(String args) {
        expression = argsSplit.divide(args); // 숫자와 부호 String[] 으로 나누기
        answer = convert(expression[0]);    // 처음 숫자 정보 입력
        for (int i = 1; i < expression.length; i += 2) {
            answer = compute(answer, expression[i], convert(expression[i + 1]));
        }
        return String.valueOf(answer);
    }

    // 부호에 따른 계산
    private double compute(double x, String op, double y) {
        return calculator.compute(x, op, y);
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
