import java.io.*;
import java.util.*;

public class Main {

    public static final int TIME = 0;
    public static final int PRICE = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            table[i][TIME] = Integer.parseInt(st.nextToken());
            table[i][PRICE] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            if(i + table[i][TIME] <= N){
                dp[i + table[i][TIME]] = Math.max(dp[i + table[i][TIME]],dp[i] + table[i][PRICE]);
            }
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }

        System.out.println(dp[N]);
    }
}