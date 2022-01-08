import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> bucket = new HashSet<>();
        for(int num : nums){
            bucket.add(num);
        }

        int bucketSize = bucket.size();
        int maximum = nums.length / 2;
        return bucketSize < maximum ? bucketSize : maximum;
    }
}