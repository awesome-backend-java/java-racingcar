package S01;

public class CalculatorOptional {
    private final SentenceSplit argsSplit;
    private final Calculator calculator;

    // ArgsSplit,HashMap class 초기화 설정
    public CalculatorOptional() {
        argsSplit = new SentenceSplit();
        calculator = new Calculator();
    }

    // 입력된정보 숫자와,부호 나눠서 앞에서부터 세개씩 계산
    public String computeAll(String args) {
        String[] expression = argsSplit.divide(args); // 숫자와 부호 String[] 으로 나누기
        double total = divide(expression);
        return String.valueOf(total);
    }

    // 입력된 정보 3개 단위로 분리하며 계산
    private double divide(String[] expression) {
        double answer = toDouble(expression[0]);    // 처음 숫자 정보 입력
        for (int i = 1; i < expression.length; i += 2) {
            answer = compute(answer, expression[i], toDouble(expression[i + 1]));
        }
        return answer;
    }

    // 부호에 따른 계산
    private double compute(double frontNumber, String operation, double backNumber) {
        return calculator.compute(frontNumber, operation, backNumber);
    }

    // double형 소수점 변환
    private double toDouble(String sentence) {
        int naturalNumber = sentence.indexOf('.');
        if (naturalNumber < 0) {
            return Double.parseDouble(sentence);
        }
        return toDecimal(sentence, naturalNumber);
    }

    private double toDecimal(String sentence, int naturalNumber) {
        int decimalCount = sentence.length() - naturalNumber - 1;
        String expression = sentence.replace(".", "");
        double standardDecimal = 0.1;

        return Long.parseLong(expression) * Math.pow(standardDecimal, decimalCount);
    }

}
