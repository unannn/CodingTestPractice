class Solution {
    public String solution(String s) {
        char[] charArray = s.toCharArray();
        char tmp;
        for (int i = 0; i < charArray.length - 1; i++) {
            for (int j = 0; j < charArray.length - i - 1; j++) {
                if(charArray[j] < charArray[j+1]){
                    tmp = charArray[j];
                    charArray[j] = charArray[j + 1];
                    charArray[j + 1] = tmp;
                }
            }
        }
        return String.valueOf(charArray);
    }
}