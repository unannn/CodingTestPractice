import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int answer = Integer.MAX_VALUE;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] dp = new int[100001];
        Arrays.fill(dp,-1);
        queue.add(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (dp[current.position] < current.second) continue;

            if(current.position == K) break;

            int[] nextPosition = {current.position - 1, current.position + 1, current.position * 2};
            int[] nextSecond = {current.second + 1, current.second + 1, current.second};
            for (int i = 0; i < nextPosition.length; i++) {
                if (nextPosition[i] >= 0 && nextPosition[i] <= 100000) {
                    if (dp[nextPosition
[i]] == -1) {
                        queue.add(new Node(nextPosition[i], nextSecond[i]));
                    }
                }
            }
        }
        System.out.println(dp[K]);
    }
    static class Node implements Comparable<Node>{
        private int position;
        private int second;

        public Node(int position, int second) {
            this.position = position;
            this.second = second;
        }

        @Override
        public int compareTo(Node o) {
            if(o.position == this.position) return o.second - this.second;
            return o.position - this.position;
        }
    }
}