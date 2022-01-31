import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {

        Map<String, List<String>> userMap = new LinkedHashMap<>();
        Map<String, Integer> reportMap = new HashMap<>();
        for (String id : id_list) {
            userMap.put(id, new ArrayList<>());
            reportMap.put(id, 0);
        }

        for (String s : reports) {
            String[] report = s.split(" ");
            List<String> individualReports = userMap.get(report[0]);
            if(!individualReports.contains(report[1])){
                individualReports.add(report[1]);
                reportMap.put(report[1], reportMap.get(report[1]) + 1);
            }
        }

        List<String> suspendId = new ArrayList<>();
        reportMap.forEach((key, value) -> {
            if (value >= k) {
                suspendId.add(key);
            }
        });

        int[] answer = new int[userMap.size()];
        int index = 0;
        for (Map.Entry<String, List<String>> entry : userMap.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            for (String id : value) {
                answer[index] += suspendId.contains(id) ? 1 : 0;
            }
            index++;
        }


        return answer;
    }
}