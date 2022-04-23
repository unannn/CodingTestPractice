import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] P = new long[101];
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        P[4] = 2;
        P[5] = 2;

        int knownIndex = 5;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N <= knownIndex) {
                sb.append(P[N]).append("\n");
                continue;
            }

            for (int j = knownIndex + 1; j <= N; j++) {
                P[j] = P[j - 1] + P[j - 5];
            }
            sb.append(P[N]).append("\n");
            knownIndex = N;
        }
        System.out.println(sb.toString());
    }
}