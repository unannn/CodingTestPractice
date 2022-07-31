import java.util.*;

class Solution {
    public int solution(String name) {

        int answer = 0;
        char[] initArr = new char[name.length()];
        Arrays.fill(initArr,'A');
        int it = 0;
        do{
            char c = name.charAt(it);
            int sub = c - 'A';
            if(sub <= 13){
                answer += sub;
            } else{
                answer += 26 - sub;
            }
            initArr[it] = c;

            int right = it;
            int left = it;
            for (int i = 0, size = name.length(); i < size; i++) {
                right += 1;
                left -= 1;
                if(right == size) right = 0;
                if(left < 0) left = size - 1;

                if(name.charAt(right) != 'A' && initArr[right] != name.charAt(right)) {
                    answer += i + 1;
                    it = right;
                    break;
                }

                if(name.charAt(left) != 'A' && initArr[left] != name.charAt(left)){
                    answer += i + 1;
                    it = left;
                    break;
                }
            }
        }while(!String.valueOf(initArr).equals(name));
        return answer;
    }
}