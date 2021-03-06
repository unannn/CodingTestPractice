import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;
        Queue<Node> queue = new ArrayDeque<>();
        int[] dp = new int[100001];
        Arrays.fill(dp,Integer.MAX_VALUE);
        queue.add(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (dp[current.position] <= current.second) continue;

            dp[current.position] =  current.second;

            if(current.position == K) break;

            int[] nextPosition = {current.position * 2, current.position - 1, current.position + 1};
            int[] nextSecond = { current.second, current.second + 1, current.second + 1};
            for (int i = 0; i < nextPosition.length; i++) {
                if (nextPosition[i] >= 0 && nextPosition[i] <= 100000) {
                    if(dp[nextPosition[i]] > nextSecond[i]){
                        queue.add(new Node(nextPosition[i], nextSecond[i]));
                    }
                }
            }
        }
        System.out.println(dp[K]);
    }
    static class Node{
        private int position;
        private int second;

        public Node(int position, int second) {
            this.position = position;
            this.second = second;
        }
    }
}