import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] priorities, int location) {
        List<Integer> queue = Arrays.stream(priorities)
                .boxed()
                .map(i -> new Integer(i))
                .collect(Collectors.toList());
        Arrays.sort(priorities);

        int maxIndex = priorities.length - 1;
        Integer findDoc = queue.get(location);
        List<Integer> orders = new ArrayList<>();
        while(maxIndex >= 0){
            Integer temp = queue.remove(0);
            if (temp < priorities[maxIndex]) {
                queue.add(temp);
            } else {
                orders.add(temp);
                maxIndex--;
            }
        }

        int i = 1;
        for (Integer order : orders) {
            if(order == findDoc) return i;
            i++;
        }
        return 0;
    }
}