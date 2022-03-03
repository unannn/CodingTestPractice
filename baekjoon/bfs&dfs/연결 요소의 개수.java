import java.util.*;

public class Main{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        Node[] graph = new Node[v + 1];
        for(int i = 1; i <= v;i++){
            graph[i] = new Node(i);
        }

        int e = sc.nextInt();
        for(int i = 0; i < e;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].getAdjacent().add(graph[b]);
            graph[b].getAdjacent().add(graph[a]);
        }

        int num = 0;
        for(int i = 1; i <= v;i++){
            if(!graph[i].isVisited()){
                num++;
                dfs(graph[i]);
            }
        }
        System.out.println(num);
    }

    private static void dfs(Node node){
        if(node.isVisited()) return;
        node.setVisited(true);
        List<Node> adjacent = node.getAdjacent();
        for(Node a : adjacent){
            dfs(a);
        }
    }

    private static class Node{
        private int data;
        private List<Node> adjacent;
        private boolean visited;

        Node(int data){
            this.data = data;
            adjacent = new LinkedList<>();
        }

        public int getData(){
            return data;
        }

        public List<Node> getAdjacent(){
            return adjacent;
        }

        public boolean isVisited(){
            return visited;
        }

        public void setVisited(boolean visited){
            this.visited = visited;
        }
    }
}