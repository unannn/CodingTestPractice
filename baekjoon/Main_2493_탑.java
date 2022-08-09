import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] tops = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			tops[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] answer = new int[N];
		
		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[]{N - 1, tops[N - 1]});
		for(int i = N - 2; i >= 0; i--) {
			while(!stack.isEmpty() && tops[i] >= stack.peekFirst()[1]) {
				int[] front = stack.pop();
				answer[front[0]] = i + 1;
			}
			stack.push(new int[] {i,tops[i]});
			
		}
		StringBuilder sb = new StringBuilder();
		for(int n : answer) {
			sb.append(n).append(' ');
		}
		System.out.println(sb);
	}
}