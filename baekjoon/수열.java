import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] temperatures = new int[N];
        for (int i = 0; i < N; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += temperatures[i];
        }
        int max = sum;

        for (int i = K; i < N; i++) {
            sum = sum - temperatures[i - K] + temperatures[i];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}