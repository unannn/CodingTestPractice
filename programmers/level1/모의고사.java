import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        HashMap<Integer, Integer> studentMap = new HashMap<>();
        studentMap.put(1, 0);
        studentMap.put(2, 0);
        studentMap.put(3, 0);

        int i = 0;
        for (int answer : answers) {
            if (one[i % one.length] == answer) studentMap.put(1, studentMap.get(1) + 1);
            if (two[i % two.length] == answer) studentMap.put(2, studentMap.get(2) + 1);
            if (three[i % three.length] == answer) studentMap.put(3, studentMap.get(3) + 1);
            i++;
        }

        ArrayList<Integer> winners = new ArrayList<>();
        int max = Math.max(studentMap.get(1), Math.max(studentMap.get(2), studentMap.get(3)));

        for (int j = 1; j <= 3; j++) {
            if(studentMap.get(j) == max){
                winners.add(j);
            }
        }

        return winners.stream().mapToInt(e->e).toArray();
    }
}