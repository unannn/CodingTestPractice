
import java.io.*;
import java.util.*;

public class Solution {

	private static int[] dr = { 1, -1, 0, 0 };

	private static int[] dc = { 0, 0, 1, -1 };

	static int N;
	static int[][] map;
	static int min;
	static int[][] cpuArr;
	static boolean[] visited;
	static int MaxCoreNumber = 1;
	static int[] answers;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= T; testCase++) {

			N = Integer.parseInt(br.readLine().trim());
			min = Integer.MAX_VALUE;

			map = new int[N][N];
			cpuArr = new int[12][];
			int cpuNumber = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
							continue;
						}
						cpuArr[cpuNumber++] = new int[] { i, j };
					}
				}
			}
			
			answers = new int[cpuNumber];
			Arrays.fill(answers, Integer.MAX_VALUE);

			if (cpuNumber == 0) {
				min = 0;
			} else {
				cpuArr = Arrays.copyOf(cpuArr, cpuNumber);
				visited = new boolean[cpuNumber];
				comb(0, 0, 0);
			}

			
			for(int i = cpuNumber - 1; i >= 0; i--) {
				if(answers[i] != Integer.MAX_VALUE) {
					min = answers[i];
					break;
				}
			}
			
			sb.append('#').append(testCase).append(' ').append(min == Integer.MAX_VALUE ? 0 : min).append('\n');
		}
		System.out.println(sb);
	}

	static void comb(int depth, int sum, int start) {
		
		if (depth == cpuArr.length) {
			answers[depth - 1]= Math.min(answers[depth - 1], sum);
			return;
		}

		boolean flag = false;
		for (int i = start; i < cpuArr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				for (int j = 0; j < 4; j++) {
					int cnt = 0;
					boolean success = false;
					int nr = cpuArr[i][0] + dr[j];
					int nc = cpuArr[i][1] + dc[j];
					while (isValid(nr, nc)) {
						if (map[nr][nc] != 0) {
							success = false;
							break;
						}
						success = true;
						nr += dr[j];
						nc += dc[j];
						cnt++;
					}

					if (success) {

						if (MaxCoreNumber < depth + 1) {
							MaxCoreNumber = depth + 1;
						}

						flag = true;

						nr = cpuArr[i][0] + dr[j];
						nc = cpuArr[i][1] + dc[j];
						while (isValid(nr, nc)) {
							map[nr][nc] = 1;
							nr += dr[j];
							nc += dc[j];
						}

						comb(depth + 1, sum + cnt, i + 1);

						nr = cpuArr[i][0] + dr[j];
						nc = cpuArr[i][1] + dc[j];
						while (isValid(nr, nc)) {
							map[nr][nc] = 0;
							nr += dr[j];
							nc += dc[j];
						}
					}

				}
				visited[i] = false;
			}
		}

		if (!flag && depth == MaxCoreNumber) {
			//min = Math.min(min, sum);
			answers[MaxCoreNumber] = Math.min(answers[MaxCoreNumber], sum);
		}
	}

	static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}