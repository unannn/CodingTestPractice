import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Node> queue = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < N;i++) {
			int c = Integer.parseInt(br.readLine());
			if(c != 0) {
				queue.add(new Node( Math.abs(c), c));
			} else {
				
				sb.append(queue.isEmpty() ? 0 : queue.poll().element).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	static class Node implements Comparable<Node>{
		int abs;
		int element;
		public Node(int abs, int element) {
			this.abs = abs;
			this.element = element;
		}
		@Override
		public int compareTo(Node o) {
			if(abs == o.abs) return element - o.element;
			return abs - o.abs;
		}
	}
}
