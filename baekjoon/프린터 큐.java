import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Deque<int[]> queue = new ArrayDeque<>();
            int topPriority = 0;
            for (int j = 0; j < N; j++) {
                int priority = Integer.parseInt(st.nextToken());
                if(topPriority < priority){
                    topPriority = priority;
                }
                queue.addLast(new int[]{j,priority});
            }
            
            int number = 0;
            while(queue.size() > 0){
                if(topPriority == queue.peekFirst()[1]) {
                    number++;
                    int[] extract = queue.removeFirst();
                    if(extract[0] == M){
                        sb.append(number).append('\n');
                        break;
                    }
                    topPriority = queue.stream().max((o1, o2) -> o1[1] - o2[1]).get()[1];
                }else{
                    queue.addLast(queue.removeFirst());
                }
            }
        }
        System.out.println(sb.toString());
    }
}