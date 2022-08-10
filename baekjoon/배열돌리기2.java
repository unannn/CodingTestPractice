import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        for(int level = 0, max = (int)Math.min(N, M) / 2; level < max; level++){

            int h = N - 2*level;
            int w = M - 2*level;
            int rot = R % (2 * (h + w - 2));
            for(int i = 0; i < rot;i++){
                int r = level;
                int c = level;
                int nr;
                int nc ;
                int current = arr[r][c];
                int next;

                for(int j = 0; j < 4;j++){
                    if(j == 0 || j == 2){
                        for (int k = 0; k < h - 1; k++) {
                            nr = r + dr[j];
                            nc = c + dc[j];
                            next = arr[nr][nc];
                            arr[nr][nc] = current;
                            current = next;
                            r = nr;
                            c = nc;
                        }
                    }else{
                        for (int k = 0; k < w - 1; k++) {
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

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb. append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}