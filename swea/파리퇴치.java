import java.util.*;
import java.io.*;

public class Solution{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[N+1][N+1];
			for(int i = 1;i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++) {
					dp[i][j] = dp[i][j-1] + Integer.parseInt(st.nextToken());	
				}
				for(int j = 1; j <= N; j++) {
					dp[i][j] += dp[i - 1][j];
				}
			}
			
			int max = 0;
			for(int i = M; i <= N; i++) {
				for(int j = M; j <= N; j++) {
					max = Math.max(max, dp[i][j] - dp[i - M][j] - dp[i][j - M] + dp[i - M][j - M]);
				}
			}
			
			sb.append('#').append(test_case).append(' ').append(max).append('\n');
		}
		System.out.println(sb);
	}
}
