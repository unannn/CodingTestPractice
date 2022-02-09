import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int h = citations.length;
        while(h > 0){
            int i = citations.length - h;
            if(citations[i] >= h){
                if(i + 1 <= h){
                    break;
                }
            }
            h--;
        }
        return h;
    }
}