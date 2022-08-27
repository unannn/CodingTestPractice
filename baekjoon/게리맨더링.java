import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] populations;
    static List<Integer>[] adjLists;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adjLists = new List[N];
        for (int i = 0; i < N; i++) {
            adjLists[i] = new ArrayList<>();
        }

        populations = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            populations[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            for (int j = 0; j < T; j++) {
                int to = Integer.parseInt(st.nextToken()) - 1;
                adjLists[i].add(to);
            }
        }

        for(int i = 1; i <= N / 2; i++){
            int[] arr = new int[i];
            comb(i, 0, 0, arr);
        }
        System.out.println(answer != Integer.MAX_VALUE ? answer : -1);
    }

    private static void comb( int L, int start, int depth, int[] arr){
        if(L == depth){
            Set<Integer> guSet = new HashSet<>();
            dfs(guSet, arr, arr[0]);
            if(guSet.size() == L){ //두번째 선거구 탐색
                int firstSum = 0;
                for(int n : guSet){
                    firstSum += populations[n];
                }

                int[] arr2 = new int[N - L];
                for(int i = 0,j = 0; i < N; i++){
                    if(!guSet.contains(i)){
                        arr2[j++] = i;
                    }
                }

                dfs(guSet, arr2, arr2[0]);

                if(guSet.size() == N){
                    int secondSum = 0;
                    for(int n : guSet){
                        secondSum += populations[n];
                    }
                    secondSum -= firstSum;
                    answer = Math.min(answer, Math.abs(firstSum - secondSum));
                }
            }
            return;
        }

        for(int i = start; i < N; i++){
            arr[depth] = i;
            comb(L, i + 1, depth + 1, arr);
        }
    }

    private static void dfs(Set<Integer> guSet, int[] arr, int current){
        guSet.add(current);
        List<Integer> adjList = adjLists[current];
        for(int adj : adjList){
            if(exist(adj, arr) && !guSet.contains(adj)){
                dfs(guSet, arr, adj);
            }
        }

    }

    private static boolean exist(int v, int[] arr){
        for(int n : arr){
            if(n == v) return true;
        }
        return false;
    }
}