import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] arr;
    private static boolean[] visited;
    private static int[] answer;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        sequence(0, 0, M);
        System.out.println(sb.toString());
    }

    private static void sequence(int start, int level,int r) {
        if (level == r) {
            for (int i = 0; i < r; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = 0; i < arr.length; i++) {
            if (before != arr[i]){
                answer[level] = arr[i];
                before = arr[i];
                sequence(i,level + 1, r);
            }
        }
    }
}