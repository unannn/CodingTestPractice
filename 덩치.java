import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[][] wh = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            wh[i][0] = X;
            wh[i][1] = Y;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (wh[i][0] < wh[j][0] && wh[i][1] < wh[j][1]) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb.toString());
    }
}