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

            int[][] board = new int[9][9];

            StringTokenizer st;
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean failed = false;

            //세로줄 검사
            row:
            for (int i = 0; i < 9; i++) {
                Set<Integer> numbers = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    if(numbers.contains(board[i][j])){
                        failed = true;
                        break row;
                    }
                    numbers.add(board[i][j]);
                }
            }

            if (failed){
                System.out.println("#" + test_case + " " + 0);
                continue;
            }

            //가로줄 검사
            column:
            for (int i = 0; i < 9; i++) {
                Set<Integer> numbers = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    if(numbers.contains(board[j][i])){
                        failed = true;
                        break column;
                    }
                    numbers.add(board[j][i]);
                }
            }

            if (failed){
                System.out.println("#" + test_case + " " + 0);
                continue;
            }

            //작은격자 검사
            square:
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Set<Integer> numbers = new HashSet<>();
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if(numbers.contains(board[i*3+k][j*3+l])){
                                failed = true;
                                break square;
                            }
                            numbers.add(board[i * 3 + k][j * 3 + l]);
                        }
                    }
                }
            }

            if (failed){
                System.out.println("#" + test_case + " " + 0);
                continue;
            }

            System.out.println("#" + test_case + " " + 1);
        }
    }
}