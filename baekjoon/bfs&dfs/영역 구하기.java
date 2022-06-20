import java.io.*;
import java.util.*;

public class Main {

    private final static int[] dx = {1, 0, -1, 0};
    private final static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] paper = new int[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int xx = Integer.parseInt(st.nextToken());
            int yy = Integer.parseInt(st.nextToken());

            for (int j = y; j < yy; j++) {
                for (int k = x; k < xx; k++) {
                    paper[j][k] = 1;
                }
            }
        }

        PriorityQueue<Integer> answer = new PriorityQueue<>();

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(paper[i][j] == 0){
                    int count = 0;
                    queue.add(new int[]{i, j});
                    while(!queue.isEmpty()){
                        int[] coord = queue.poll();
                        int a = coord[0];
                        int b = coord[1];
                        if(paper[a][b] != 0){
                            continue;
                        }
                        paper[a][b] = 2;
                        count++;

                        for (int t = 0; t < 4; t++) {
                            int newX = a + dx[t];
                            int newY = b + dy[t];

                            //불가능한 x 또는 y일 ㄱㅇ우
                            if((newX < 0 || newX >= M) || (newY < 0 || newY >= N)){
                                continue;
                            }

                            if(paper[newX][newY] == 0){
                                queue.add(new int[]{newX, newY});
                            }
                        }
                    }
                    answer.add(count);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        while(!answer.isEmpty()){
            sb.append(answer.poll()).append(" ");
        }
        System.out.println(sb);
    }
}