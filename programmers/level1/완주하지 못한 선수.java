import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> participantMap = new LinkedHashMap<>();
        for (String s : participant) {
            if(participantMap.containsKey(s)){
                participantMap.replace(s,participantMap.get(s)+1);
            }
            else{
                participantMap.put(s, 1);
            }
        }

        for (String s : completion) {
            participantMap.replace(s,participantMap.get(s)-1);
        }

        for (String s : participant) {
            if(participantMap.get(s) > 0) return s;
        }
        return null;
    }
}