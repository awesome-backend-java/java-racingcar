package S01;

public class ArgsSplit {

    public String[] expression;

    public String[] divide(String args) {
        expression = findWord(args);
        return expression;
    }
    private String[] findWord(String args) {
        String s = "";
        for (int i = 0; i < args.length(); i++) {
            s += compare(args.charAt(i));
        }
        return s.split(" ");
    }
    private String compare(char ch) {
        if ('0' <= ch && ch <= '9'|| ch=='.') {
            return String.valueOf(ch);
        }
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return " " + ch +" ";
        }
        return "";
    }
}
