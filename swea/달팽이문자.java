import java.util.*;
import java.io.*;

public class Solution{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		int[] dx = {1, 0, -1 ,0};
		int[] dy = {0, 1, 0, -1};
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = Integer.parseInt(br.readLine());
			int[][] snail = new int[N][N];
			
			int x = 0, y = 0;
			int n = 1;
			for(int i = 0; i < 2 * N- 1; i++) {				
				while(isValid(snail, x + dx[i % 4], y + dy[i % 4])) {
					snail[y][x] = n++;
					x += dx[i % 4];
					y += dy[i % 4];
				}
			}
			snail[y][x] = n;
			
			sb.append('#').append(test_case).append('\n');
			for (int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(snail[i][j]).append(' ');
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
	
	final static boolean isValid(int[][] snail, int x, int y) {
		return (x >= 0 && x < snail.length) && (y >= 0 && y < snail.length) && snail[y][x] == 0;
	}
}
