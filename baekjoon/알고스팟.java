import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] map;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		int[][] distances = new int[N][M];
		for(int i = 0; i < N; i++) {
			Arrays.fill(distances[i], Integer.MAX_VALUE);
		}
		
		distances[0][0] = 0;
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> pq = new PriorityQueue<int[]>((o1,o2)-> o1[2] - o2[2]);
		pq.offer(new int[] {0,0,0});
		
		while(!pq.isEmpty()) {
			int[] current = pq.poll();
			
            if(current[0] == N-1 && current[1] == M -1)break;
            
			for(int i = 0; i < 4; i++) {
				int nr = current[0] + dr[i];
				int nc = current[1] + dc[i];
				if(isValid(nr,nc)) {			
					if(distances[nr][nc] > current[2] + map[nr][nc]) {
						distances[nr][nc] =  current[2] +  map[nr][nc];
						pq.offer(new int[] {nr,nc,distances[nr][nc]});
					}
				}
			}
		}
		System.out.println(distances[N-1][M-1]);
	}
	
	private static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
