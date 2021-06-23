package S01;

public class ArgsSplit {

    public String[] expression;

    // 구별된 부호와 숫자 리턴
    public String[] divide(String args) {
        expression = findWord(args);
        return expression;
    }

    // String[] 으로 부호와 숫자 구별
    private String[] findWord(String args) {
        String s = "";
        for (int i = 0; i < args.length(); i++) {
            s += compare(args.charAt(i));
        }
        return s.split(" ");
    }

    // 숫자면 붙여서 부호면 띄어쓰기, +,-,*,/ 이외의 문자 무시
    private String compare(char ch) {
        if ('0' <= ch && ch <= '9' || ch == '.') {
            return String.valueOf(ch);
        }
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return " " + ch + " ";
        }
        return "";
    }
}
