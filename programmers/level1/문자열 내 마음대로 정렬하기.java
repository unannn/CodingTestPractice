import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                .sorted((s1,s2)->{
                    if(s1.charAt(n) > s2.charAt(n))return 1;
                    else if(s1.charAt(n) < s2.charAt(n)) return -1;
                    else{
                        if(s1.compareTo(s2) > 0) return 1;
                        else return -1;
                    }
                })
                .toArray(String[]::new);
    }
}