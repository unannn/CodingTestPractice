import java.util.regex.Pattern;

class Solution {
    public boolean solution(String s) {
        int len = s.length();
        return Pattern.matches("[0-9]{4}|[0-9]{6}",s);
    }
}