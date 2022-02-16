class Solution {
    public String solution(String s) {
        char[] charArr = s.toCharArray();
        char prevChar = ' ';
        for (int i = 0; i < charArr.length; i++) {
            if(!Character.isDigit(charArr[i]) && charArr[i] != ' '){
                if (prevChar == ' ') {
                    charArr[i] = Character.toUpperCase(charArr[i]);
                } else {
                    charArr[i] = Character.toLowerCase(charArr[i]);
                }
            }
            prevChar = charArr[i];
        }
        return String.valueOf(charArr);
    }
}