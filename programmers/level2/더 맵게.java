import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (Integer s : scoville) {
            heap.add(s);
        }

        int answer = 0;
        Integer first = null, second = null;
        while ((first = heap.poll()) != null
                && (second = heap.poll()) != null){ // &&문은 왼쪽부터 계산, 먼저 계산한 값이 거짓이면 더이상 연산 X
            heap.add(first + second * 2);
            answer++;
            if(heap.peek() >= K){
                return answer;
            }
        }
        return -1;
    }
}