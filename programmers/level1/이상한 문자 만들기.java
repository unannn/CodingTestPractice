class Solution {
    public String solution(String s) {
        boolean isOdd = true;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == ' '){
                isOdd = true;
            }
            else{
                if(isOdd) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                }
                else{
                    charArray[i] = Character.toLowerCase(charArray[i]);
                }
                isOdd = !isOdd;
            }
        }
        return String.valueOf(charArray);
    }
}