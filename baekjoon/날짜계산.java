import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
			
		int e = 1, s = 1, m = 1;
		int answer = 1;
		while(!(e == E && s == S && m == M)) {
			e++; s++; m++;
			e = e > 15 ? 1 : e;
			s = s > 28 ? 1 : s;
			m = m > 19 ? 1 : m;
			answer++;
		}
		
		System.out.println(answer);
	}
}