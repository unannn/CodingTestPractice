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
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] puzzle = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    puzzle[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - M + 1; j++) {

                    //가로 방향 조사
                    int length = 0;
                    for (int k = 0; k < M; k++) {
                        if(puzzle[i][j + k] != 1){
                            break;
                        }
                        length++;
                    }

                    if(length == M && (j == 0 || puzzle[i][j - 1] == 0) && (j + M == N || puzzle[i][j + M] == 0)) {
                        answer++;
                    }

                    //세로 방향 조사
                    length = 0;
                    for (int k = 0; k < M; k++) {
                        if(puzzle[j+k][i] != 1){
                            break;
                        }
                        length++;
                    }

                    if(length == M && (j == 0 || puzzle[j - 1][i] == 0) && (j + M == N || puzzle[j + M][i] == 0)) {
                        answer++;
                    }
                }
            }

            System.out.println("#" + test_case + " " + answer);

        }
    }
}