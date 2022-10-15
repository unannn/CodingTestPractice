import java.io.*;
import java.util.*;

public class Main {
	static int[] sushi;
	static int N, d, k, c;
	static int maxCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		sushi = new int[N];
		for (int i = 0; i < N; i++)
			sushi[i] = Integer.parseInt(br.readLine());

		int[] select = new int[d + 1];

		select[c]++;
		int cnt = 1;

		for (int i = 0; i < k; i++) {
			if (select[sushi[i]] == 0)
				cnt++;
			select[sushi[i]]++;
		}

		for (int i = 1; i < N; i++) {

			select[sushi[i - 1]]--;
			if (select[sushi[i - 1]] == 0)
				cnt--;

			if (select[sushi[(i + k - 1) % N]] == 0)
				cnt++;
			select[sushi[(i + k - 1) % N]]++;

			maxCnt = Math.max(maxCnt, cnt);
		}

		System.out.println(maxCnt);

		br.close();
	}
}
