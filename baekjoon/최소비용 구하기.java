import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        //그래프 초기화
        int[][] costs = new int[N][N];
        for (int i = 0; i < costs.length; i++) {
            Arrays.fill(costs[i],-1);

        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            if(costs[a][b] != -1){
                costs[a][b] = Math.min(cost, costs[a][b]);
            }else{
                costs[a][b] = cost;
            }
        }

        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int dest = Integer.parseInt(st.nextToken()) - 1;

        boolean[] visited = new boolean[N];
        int[] distanses = new int[N];

        Arrays.fill(distanses,Integer.MAX_VALUE);
        distanses[start] = 0;
        visited[start] = true;
        for(int i = 0; i < N;i++){
            if(costs[start][i] != -1){
                distanses[i] = costs[start][i];
            }
        }

        int current = findMinimunIndex(distanses, visited);
        while(current != -1){
            visited[current] = true;
            for (int j = 0; j < N; j++) {
                if (costs[current][j] != -1 && !visited[j]){
                    distanses[j] = Math.min(distanses[j], distanses[current] + costs[current][j]);
                }
            }
            current = findMinimunIndex(distanses, visited);
        }


        System.out.println(distanses[dest]);
    }

    static int findMinimunIndex(int[] distanses, boolean[] visited){

        PriorityQueue<Entry> queue = new PriorityQueue<>();
        for (int i = 0; i < distanses.length; i++) {
            if(!visited[i]){
                queue.add(new Entry(i,distanses[i]));
            }
        }

        if(queue.isEmpty())return -1;

        return queue.poll().index;
    }

    static class Entry implements Comparable{
        int index;
        int data;

        public Entry(int index, int data) {
            this.index = index;
            this.data = data;
        }


        @Override
        public int compareTo(Object o) {
            return this.data - ((Entry)o).data;
        }
    }
}