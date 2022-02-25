import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> heap = new PriorityQueue<>();
        for (Integer s : scoville) {
            heap.add(s);
        }

        Integer first = null, second = null;
        while ((first = heap.poll()) != null
                && (second = heap.poll()) != null){ // &&문은 왼쪽부터 계산
            heap.add(first + second * 2);
            answer++;
            if(heap.peek() >= K){
                return answer;
            }
        }
        return -1;
    }
}