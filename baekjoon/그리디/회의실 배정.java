import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] times = new int[n][2];
        for(int i = 0;i < n;i++){
            times[i][0] = sc.nextInt();
            times[i][1] = sc.nextInt();
        }

        Arrays.sort(times,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]){
                    return o1[1] - o2[1];
                } else{
                    return (o2[1] - o2[0]) - (o1[1] - o1[0]);
                }
            }});

        List<int[]> meetings = new ArrayList<>();
        int last = 0;
        for(int[] time: times){
            if(last <= time[0] ){
                meetings.add(new int[]{time[0],time[1]});
                last = time[1];
            }
        }
        System.out.println(meetings.size());
    }
}