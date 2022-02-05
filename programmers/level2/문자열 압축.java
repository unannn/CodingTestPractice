import java.util.*;

class Solution {
    public int solution(String s) {
        int min = s.length();
        for(int i = 1; i <= s.length();i++){
            String compress = getCompress(s, i);
            min = Math.min(min, compress.length());
        }
        return min;
    }

    private String getCompress(String s,int unit){
        List<String> pieces = new ArrayList<>();
        for(int i = 0;i < s.length();i += unit){
            int end = i + unit > s.length() ? s.length() : i + unit;
            pieces.add(s.substring(i, end));
        }

        StringBuilder sb = new StringBuilder();
        int start = 0, count = 0;
        for (int i = 0; i < pieces.size(); i++) {
            if(pieces.get(start).equals(pieces.get(i))){
                count++;
            }
            else{
                if(count != 1) sb.append(count);
                sb.append(pieces.get(start));
                count = 1;
                start = i;
            }
        }
        if(count != 1) sb.append(count);
        sb.append(pieces.get(start));

        return sb.toString();
    }
}