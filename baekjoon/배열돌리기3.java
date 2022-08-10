import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            arr = run(Integer.parseInt(st.nextToken()), arr);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sb. append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int[][] run(int type, int[][] arr){
        switch (type){
            case 1:
                one(arr);
                break;

            case 2:
                two(arr);
                break;

            case 3:
                arr = three(arr);
                break;

            case 4:
                arr = four(arr);
                break;

            case 5:
                arr = five(arr);
                break;

            case 6:
                arr = six(arr);
                break;
        }
        return arr;
    }

    private static void one(int[][] arr){
        int length = arr.length;
        for(int i = 0; i < length / 2; i++){
            int[] tmp = arr[i];
            arr[i] = arr[length - i - 1];
            arr[length - i - 1] = tmp;
        }
    }

    private static void two(int[][] arr){
        int height = arr.length;
        int width = arr[0].length;
        for(int i = 0; i < height; i++){
            for(int j = 0;j < width / 2; j++){
                int tmp = arr[i][j];
                arr[i][j] = arr[i][width - j - 1];
                arr[i][width - j - 1] = tmp;
            }
        }
    }

    private static int[][] three(int[][] arr){
        int N = arr.length;
        int M = arr[0].length;
        int[][] temp = new int[M][N];
        for(int i = 0; i < M;i++){
            for (int j = 0; j < N; j++) {
                temp[i][j] = arr[N - j - 1][i];
            }
        }
        return temp;
    }

    private static int[][] four(int[][] arr){
        int N = arr.length;
        int M = arr[0].length;
        int[][] temp = new int[M][N];
        for(int i = 0; i < N;i++){
            for (int j = 0; j < M; j++) {
                temp[j][i] = arr[i][M - j - 1];
            }
        }
        return temp;
    }
    private static int[][] five(int[][] arr){
        int N = arr.length;
        int M = arr[0].length;
        int[][] temp = new int[N][M];
        int[] dr = {0, N / 2, N / 2, 0, 0};
        int[] dc = {0, 0, M / 2, M / 2, 0};
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < N / 2; j++) {
                for (int k = 0; k < M / 2; k++) {
                    temp[dr[i] + j][dc[i] + k] = arr[dr[i + 1] + j][dc[i + 1] + k];
                }
            }
        }
        return temp;
    }

    private static int[][] six(int[][] arr){
        int N = arr.length;
        int M = arr[0].length;
        int[][] temp = new int[N][M];
        int[] dr = {0, 0 , N / 2, N / 2, 0};
        int[] dc = {0, M / 2, M / 2, 0, 0};
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < N / 2; j++) {
                for (int k = 0; k < M / 2; k++) {
                    temp[dr[i] + j][dc[i] + k] = arr[dr[i + 1] + j][dc[i + 1] + k];
                }
            }
        }
        return temp;
    }
}