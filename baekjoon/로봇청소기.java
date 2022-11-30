import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    static int[][] room;
    static int N, M;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        int startD = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(startR, startC, startD);
        System.out.println(answer);
    }

    static void dfs(int r, int c, int d) {
        if (room[r][c] != 0) return;
        room[r][c] = 2; //현재 위치 청소
        answer++;

        int nd = d;
        for (int i = 0; i < 4; i++) {
            nd = (nd - 1 + 4) % 4;
            int nr = r + dr[nd];
            int nc = c + dc[nd];
            if (isValid(nr, nc) && room[nr][nc] == 0) {
                dfs(nr, nc, nd);
            }
        }

    }

    static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
