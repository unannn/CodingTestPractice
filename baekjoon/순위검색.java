import java.util.*;
    
class Solution{

    private static class Info {
        String lang;
        String job;
        String career;
        String food;
        String grade;

        public Info(String[] info) {
            this.lang = info[0];
            this.job = info[1];
            this.career = info[2];
            this.food = info[3];
            this.grade = info[4];
        }
    }

    public int[] solution(String[] info, String[] query) {
        List<Info> infos = new ArrayList<>();
        for (String s : info) {
            infos.add(new Info(s.split(" ")));
        }

        infos.sort((o1, o2) -> {
            if(Integer.parseInt(o1.grade) != Integer.parseInt(o2.grade)) return Integer.parseInt(o1.grade) - Integer.parseInt(o2.grade);
            else if(o1.grade.equals("-"))

            if(o1.lang.compareTo(o2.lang) != 0) return o1.lang.compareTo(o2.lang);

            if(o1.job.compareTo(o2.job) != 0) return o1.job.compareTo(o2.job);

            if(o1.career.compareTo(o2.career) != 0) return o1.career.compareTo(o2.career);

            return o1.job.compareTo(o2.food);
        });

        int N = query.length;
        int[] answer = new int[N];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] q = parse(query[i]);
            int count = 0;

            int n = 0;
            for(int j = 0; j < info.length; j++){
                if(Integer.parseInt(infos.get(j).grade) >= Integer.parseInt(q[4])){
                    n = j;
                    break;
                }
            }
            for(int j = n; j < info.length; j++){
                if(infos.get(j).lang.equals(q[0])){
                    n = j;
                    break;
                }
            }
            for(int j = n; j < info.length; j++){
                if(infos.get(j).job.equals(q[1])){
                    n = j;
                    break;
                }
            }
            for(int j = n; j < info.length; j++){
                if(infos.get(j).career.equals(q[2])){
                    n = j;
                    break;
                }
            }
            for(int j = n; j < info.length; j++){
                if(infos.get(j).food.equals(q[3])){
                    n = j;
                    break;
                }
            }

            for(int j = n; j < info.length; j++){
                if(!infos.get(j).food.equals(q[3])) break;
                count++;
            }

            answer[i] = count;
        }
        return answer;
    }
    private String[] parse(String query) {
        return Arrays.stream(query.split(" "))
                .filter(o -> !o.equals("and"))
                .toArray(String[]::new);
    }
}