class Solution {
    public String solution(String s, int n) {
        char[] charArray = s.toCharArray();
        for(int i = 0;i < s.length();i++){
            if(Character.isUpperCase(charArray[i])){
                charArray[i] += n;
                if(!Character.isUpperCase(charArray[i])){
                    charArray[i] -= 26;
                }
            }
            else if(Character.isLowerCase(charArray[i])){
                charArray[i] += n;
                if(!Character.isAlphabetic(charArray[i])){
                    charArray[i] -= 26;
                }
            }

        }
        return String.valueOf(charArray);
    }
}