package S01;

public class SentenceSplit {
    private static final char ZERO = '0';
    private static final char NINE = '9';
    private static final char DECIMAL = '.';
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MUL = '*';
    private static final char DIV = '/';

    private final StringBuilder wordSplit; // 숫자와 부호 분리

    public SentenceSplit() {
        wordSplit = new StringBuilder();
    }

    // 구별된 부호와 숫자 리턴
    public String[] divide(String args) throws Exception {
        return findWord(args);
    }

    // String[] 으로 부호와 숫자 구별
    private String[] findWord(String args) throws Exception {
        wordSplit.delete(0, wordSplit.length());
        for (int i = 0; i < args.length(); i++) {
            String word = compareByWord(args.charAt(i));
            wordSplit.append(word);
        }
        errorCheck(wordSplit);
        return wordSplit.toString()
                .split(" ");
    }
    private void errorCheck(StringBuilder sentence) throws Exception {
        String expression = sentence.toString();
        if(expression.contains("  ") || expression.contains("..")){
            throw new Exception();
        }
    }

    // 숫자와 부호를 구별
    private String compareByWord(char word) {
        if (ZERO <= word && word <= NINE || word == DECIMAL) {
            return String.valueOf(word); // 숫자면 계속 문자를 이어붙인다.
        }
        if (word == PLUS || word == MINUS || word == MUL || word == DIV) {
            return " " + word + " "; // 부호라면 띄어쓰기로 분리한다.
        }
        return "";
    }
}