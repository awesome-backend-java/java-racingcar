package S01;

public class ArgsSplit {

    private String[] expression;
    private final StringBuilder wordSplit; // 숫자와 부호 분리
    private final char zero = '0';
    private final char nine = '9';
    private final char decimal = '.';
    private final char plus = '+';
    private final char minus = '-';
    private final char mul = '*';
    private final char div = '/';


    public ArgsSplit(){
        wordSplit = new StringBuilder();
    }
    // 구별된 부호와 숫자 리턴
    public String[] divide(String args) {
        expression = findWord(args);
        return expression;
    }
    // String[] 으로 부호와 숫자 구별
    private String[] findWord(String args) {
        wordSplit.delete(0, wordSplit.length());
        for (int i = 0; i < args.length(); i++) {
            wordSplit.append(compare(args.charAt(i)));
        }
        return wordSplit.toString()
                .split(" ");
    }
    // 숫자면 붙여서 부호면 띄어쓰기, +,-,*,/ 이외의 문자 무시
    private String compare(char word) {
        if (zero <= word && word <= nine || word == decimal) {
            return String.valueOf(word);
        }
        if (word == plus || word == minus || word == mul || word == div) {
            return " " + word + " ";
        }
        return "";
    }
}