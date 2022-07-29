import java.util.*;
class Solution {
    public String solution(String number, int k) {

        List<Character> numbers = new LinkedList<>();
        for (int i = 0,length = number.length(); i < length; i++) {
            numbers.add(number.charAt(i));
        }

        Queue<Character> q = new PriorityQueue<>();
        numbers.stream()
                .forEach(o -> q.add(o));

        int count = 0;
        for (int i = 0; i < k; i++) {
            numbers.remove(q.poll());
        }

        StringBuilder sb = new StringBuilder();
        for(Character c: numbers){
            sb.append(c);
        }
        return sb.toString();
    }
}