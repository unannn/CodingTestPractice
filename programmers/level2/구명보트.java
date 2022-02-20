import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int boat = 0;
        int j = 0;
        for(int i = people.length - 1;i >= j;i--){
            if(people[i] + people[j] <= limit){
                j++;
            }
            boat++;
        }
        return boat;
    }
}