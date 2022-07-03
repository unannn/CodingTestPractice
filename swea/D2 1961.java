import java.util.*;
import java.io.*;

class Solution{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("#" + test_case);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(matrix[N - j - 1][i]);
                }

                System.out.print(" ");

                for (int j = 0; j < N; j++) {
                    System.out.print(matrix[N - i - 1][N - j - 1]);
                }

                System.out.print(" ");

                for (int j = 0; j < N; j++) {

                    System.out.print(matrix[j][N - i - 1]);
                }

                System.out.println();
            }
        }
    }
}