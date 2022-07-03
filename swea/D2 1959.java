import java.util.*;
import java.io.*;

class Solution
{
      public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] A = new int[a];
            for (int i = 0; i < a; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] B = new int[b];
            for (int i = 0; i < b; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            if(b < a){
                int[] tmp = A;
                A = B;
                B = tmp;
            }

            int max = 0;
            int current = 0;
            int N = Math.abs(a - b) + 1;
            int M = Math.min(a,b);
            for (int i = 0; i < N; i++) {
                current = 0;
                for (int j = 0; j < M; j++) {
                    current += A[j] * B[i + j];
                }
                max = Math.max(max, current);
            }

            System.out.println("#" + test_case+ " " + max);
        }
    }  
}