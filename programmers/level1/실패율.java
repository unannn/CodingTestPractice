import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer,Double> stageFailRates = new HashMap<>();
        int allUser = stages.length;
        int stageUser;
        double failRate;
        for (int stage = 1; stage <= N; stage++) {
            stageUser = getUserNumber(stages,stage);
            failRate = (double)stageUser / allUser;
            stageFailRates.put(stage, failRate);
            allUser -= stageUser;
            allUser = allUser == 0 ? 1 : allUser;
        }

        List<Integer> keySetList = new ArrayList<>(stageFailRates.keySet());
        keySetList.sort((o1, o2) -> stageFailRates.get(o2).compareTo(stageFailRates.get(o1)));
        int[] answer = new int[N];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = keySetList.get(i);
        }
        return answer;
    }

    private int getUserNumber(int[] stages,int findStage){
        int number = 0;
        for (int stage : stages) {
            if(stage == findStage){
                number++;
            }
        }
        return number;
    }
}