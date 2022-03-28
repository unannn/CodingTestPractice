import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int INF = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        //초기화
        for(int i = 0;i < N;i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            map[S - 1][D - 1] = Math.min(C, map[S - 1][D - 1]);
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j] != INF ? map[i][j] : 0).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}