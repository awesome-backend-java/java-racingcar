package S01;

public class SentenceSplit {
    private final char zero = '0';
    private final char nine = '9';
    private final char decimal = '.';
    private final char plus = '+';
    private final char minus = '-';
    private final char mul = '*';
    private final char div = '/';

    private String[] expression;
    private final StringBuilder wordSplit; // 숫자와 부호 분리

    public SentenceSplit() {
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
            String word = compareByWord(args.charAt(i));
            wordSplit.append(word);
        }
        return wordSplit.toString()
                .split(" ");
    }

    // 숫자와 부호를 구별
    private String compareByWord(char word) {
        if (zero <= word && word <= nine || word == decimal) {
            return String.valueOf(word); // 숫자면 계속 문자를 이어붙인다.
        }
        if (word == plus || word == minus || word == mul || word == div) {
            return " " + word + " "; // 부호라면 띄어쓰기로 분리한다.
        }
        return "";
    }
}