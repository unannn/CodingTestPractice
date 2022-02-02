import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        List<Integer> lostList = Arrays.stream(lost).boxed().sorted().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().sorted().collect(Collectors.toList());
        List<Integer> overLaps = new ArrayList<>();
        for (Integer l : lostList) {
            if(reserveList.contains(l)){
                overLaps.add(l);
            }
        }

        for (Integer overLap : overLaps) {
            reserveList.remove(overLap);
            lostList.remove(overLap);
        }

        int answer = n - lostList.size();

        for (Integer l : lostList) {
            if (reserveList.contains(l - 1)) {
                answer++;
                reserveList.remove(Integer.valueOf(l - 1));
            } else if (reserveList.contains(l + 1)) {
                answer++;
                reserveList.remove(Integer.valueOf(l + 1));
            }
        }

        return answer;
    }
}