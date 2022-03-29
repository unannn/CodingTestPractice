import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static StringBuilder sb;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K;
        while ((K = Integer.parseInt(st.nextToken())) != 0) {
            sb = new StringBuilder();
            int[] S = new int[K];
            visited = new boolean[K];
            for (int i = 0; i < K; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            int[] arr = new int[6];
            combination(S,arr,0,0);
            System.out.println(sb.toString());

            st = new StringTokenizer(br.readLine());
        }
    }

    private static void combination(int[] S, int[] arr,int start, int level) {
        if(level == 6){
            for (int i = 0; i < 6; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start;i < S.length;i++){
            if (!visited[i]) {
                visited[i] = true;
                arr[level] = S[i];
                combination(S, arr, i+1, level + 1);
                visited[i] = false;
            }
        }
    }
}