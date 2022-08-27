import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] order;
    static int[][] game;
    static boolean[] visited;
    static int answer = 0;
    static int[] runners;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        order = new int[9];
        visited = new boolean[9];
        game = new int[N][9];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        runners = new int[4];
        permutation(0);
        System.out.println(answer);
    }

    private static void permutation(int depth) {
        if (depth == 9) {
            answer = Math.max(answer, sumScore());
        } else if (depth == 3) {
            order[depth] = 0;
            permutation(depth + 1);
        } else {
            for (int i = 0; i < 9; i++) {
                if (!visited[i] && i != 0) {
                    visited[i] = true;
                    order[depth] = i;
                    permutation(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    private static int sumScore() {
        if (order[0] == 4) {
            //System.out.println();
        }
        int battingOrder = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            Arrays.fill(runners, 0);
            int outCount = 0;
            while (outCount != 3) {
                int result = game[i][order[battingOrder++ % 9]];
                if (result != 0) {
                    sum += advance(runners, result);
                } else {
                    ++outCount;
                }
            }
        }
        return sum;
    }

    private static int advance(int[] runners, int n) {
        runners[0] = 1;
        int score = 0;
        for (int i = 4 - n; i < 4; i++) {
            score += runners[i];
            runners[i] = 0;
        }

        for (int i = 3 - n; i >= 0; i--) {
            runners[i + n] = runners[i];
            runners[i] = 0;
        }

        return score;
    }
}