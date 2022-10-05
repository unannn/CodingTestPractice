import java.io.*;
import java.util.*;

public class Main {

	static int H, W;
	static int[][] board;
	static boolean[][] visited;

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		board = new int[H + 2][W + 2];
		visited = new boolean[H + 2][W + 2];
		int cheezeNumber = 0;
		for (int i = 1; i <= H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1)
					cheezeNumber++;
			}
		}

		int time = 0;
		int meltingCheeze = 0;
		while (cheezeNumber > 0) {
			// visit 초기화
			for (int i = 0; i < H + 2; i++) {
				Arrays.fill(visited[i], false);
			}

			visited[0][0] = true;
			dfs(0, 0);
			meltingCheeze = melt();
			cheezeNumber -= meltingCheeze;

			time++;
		}
		System.out.println(time + "\n" + meltingCheeze);
	}

	static int melt() {
		int count = 0;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				if (board[i][j] == 2) {
					board[i][j] = 0;
					count++;
				}
			}
		}
		return count;
	}

	static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (isValid(nr, nc)) {
				if (board[nr][nc] == 1) {
					board[nr][nc] = 2;
				} else if (board[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					dfs(nr, nc);
				}
			}
		}
	}

	static boolean isValid(int r, int c) {
		return r >= 0 && r <= H + 1 && c >= 0 && c <= W + 1;
	}
}