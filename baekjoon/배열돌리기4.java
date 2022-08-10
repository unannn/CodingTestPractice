import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] operates = new int[K][3];
        for (int i = 0; i < K; i++) {
            st =  new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                operates[i][j] =  Integer.parseInt(st.nextToken());
            }
        }

        boolean[] isVisited = new boolean[operates.length];
        System.out.println(perm(arr, operates, isVisited, 0));

    }

    private static int perm(int[][] arr, int[][] operates, boolean[] isVisited,int level){
        if(level == operates.length){
            return getMinimumRowValue(arr);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < operates.length;i++){
            if(!isVisited[i]){
                int[][] temp = copy(arr);
                isVisited[i] = true;
                execute(temp, operates[i]);
                min = Math.min(min, perm(temp, operates, isVisited, level + 1));
                isVisited[i] = false;
            }
        }
        return min;
    }

    private static int[][] copy(int[][] arr){
        int[][] temp = new int[arr.length][arr[0].length];
        for(int i = 0;i < arr.length;i++){
            for (int j = 0; j < arr[0].length; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }
    private static int getMinimumRowValue(int[][] arr){
        int min = Integer.MAX_VALUE;
        for(int[] a : arr){
            int sum = 0;
            for (int number : a) {
                sum += number;
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    private static void execute(int[][] arr, int[] operate){
        int R = operate[0];
        int C = operate[1];
        int S = operate[2];

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        for(int level = 0; level < S; level++){
            int N = 2 * (S - level) + 1;

            int r = R - S + level - 1;
            int c = C - S + level - 1;
            int nr;
            int nc ;
            int current = arr[r][c];
            int next;

            for(int j = 0; j < 4;j++){
                if(j == 0 || j == 2){
                    for (int k = 0; k < N - 1; k++) {
                        nr = r + dr[j];
                        nc = c + dc[j];
                        next = arr[nr][nc];
                        arr[nr][nc] = current;
                        current = next;
                        r = nr;
                        c = nc;
                    }
                }else{
                    for (int k = 0; k < N - 1; k++) {
                        nr = r + dr[j];
                        nc = c + dc[j];
                        next = arr[nr][nc];
                        arr[nr][nc] = current;
                        current = next;
                        r = nr;
                        c = nc;
                    }
                }
            }
        }
    }
}
