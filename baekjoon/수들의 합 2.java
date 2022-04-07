import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;
        int sum = 0;
        int ans = 0;
        for (int start = 0; start < N; start++) {
            while(end < N && sum < M){
                sum += A[end++];
            }
        if(sum == M) ans++;
            sum -= A[start];
        }
        System.out.println(ans);
    }
}