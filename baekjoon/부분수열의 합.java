import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        visited = new boolean[N];
        st =  new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            combination(arr, 0, S, 0, 0, i);
        }

        System.out.println(count);

    }

    private static void combination(int[] arr, int sum, int S, int start, int level, int r) {
        if(level == r){
            if(sum == S) count++;
            return;
        }

        for(int i = start;i < arr.length;i++){
            if (!visited[i]) {
                visited[i] = true;
                combination(arr, sum + arr[i], S, i+1,level + 1, r);
                visited[i] = false;
            }
        }
    }
}