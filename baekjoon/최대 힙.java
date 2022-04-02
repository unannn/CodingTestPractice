import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(br.readLine());
            if (X != 0) {
                priorityQueue.add(X);
            }else{
                if(priorityQueue.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(priorityQueue.poll()).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}