import java.io.*;
import java.util.*;

public class Solution{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
            
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] snacks = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N;i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for(int i = 0; i < N;i++) {
				for(int j = 0;j < N; j++) {
					if(i != j) {
						int sum = snacks[i] + snacks[j];
						if(sum > max && sum <= M) {
							max = sum;
						}
					}
				}
			}
			
			sb.append('#').append(test_case).append(' ')
				.append(max != 0 ? max : -1)
				.append('\n');
		}	
		System.out.println(sb);
	}
}
