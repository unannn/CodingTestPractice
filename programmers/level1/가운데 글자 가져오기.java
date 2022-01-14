class Solution {
    public String solution(String s) {
        int l = s.length();
        return l % 2 == 0 ? s.substring(l / 2 - 1, l / 2 + 1) : s.substring(l / 2, l / 2 + 1);
    }
}