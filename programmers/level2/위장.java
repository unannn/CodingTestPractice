import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> map = new HashMap<>();
        for(String[] c : clothes){
            if(map.containsKey(c[1])){
                map.put(c[1],map.get(c[1])+ 1);
            }else{
                map.put(c[1], 1);
            }
        }
        
        List<Integer> values = new ArrayList<>(map.values());
        int answer = 1;
        for (Integer v : values) {
            answer *= v + 1;
        }
        return answer - 1;
    }
}