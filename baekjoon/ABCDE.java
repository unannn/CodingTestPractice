import java.io.*;
import java.util.*;

public class Main {

	private static int N, M;
	
	static class Node{
		int value;
		List<Node> adj;
		boolean visited;
		
		public Node(int value) {
			super();
			this.value = value;
			this.adj = new ArrayList<>();
			this.visited = false;
		}
		
		void connect(Node o) {
			this.adj.add(o);
			o.adj.add(this);
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Node[] graph = new Node[N];
		for(int i = 0; i < N;i++) {
			graph[i] = new Node(i);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].connect(graph[b]);
		}

		for (int i = 0; i < N; i++) {
			graph[i].visited = true;
			if(dfs(graph[i], 0) == 1) {

				System.out.println(1);
				return;
			}
			graph[i].visited = false;
		}
		System.out.println(0);
	}
	
	private static int dfs(Node v, int n) {
		if(n == 4) return 1;
		
		for(Node adj : v.adj) {
			if(!adj.visited) {
				adj.visited = true;

				int d = dfs(adj, n + 1);
				if(d == 1) {
					return 1;
				}
				adj.visited = false;
			}
		}
		return 0;
	}
}
