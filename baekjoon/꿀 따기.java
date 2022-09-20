import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftAcc = new int[N];
        int[] rightAcc = new int[N];

        leftAcc[0] = arr[0];
        rightAcc[N - 1] = arr[N - 1];
        for (int i = 1; i < N; i++) {
            leftAcc[i] = arr[i] + leftAcc[i - 1];
            rightAcc[i - 1] = arr[N - i - 1] + rightAcc[N - i];
        }

        int max = 0;
        int first = leftAcc[N - 1] - leftAcc[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(first - arr[i] + leftAcc[N - 1] - arr[i], max);
        }

//        first = leftAcc[N - 1] - leftAcc[0];
//        for (int i = 1; i < N; i++) {
//            max = Math.max(first - arr[N - i - 1] + rightAcc[N - 1] - arr[i], max);
//        }

        System.out.println(max);
    }
}
