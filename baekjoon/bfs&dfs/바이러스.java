import java.util.*;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int computerNumber = sc.nextInt();
        int connectionNumber = sc.nextInt();

        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < computerNumber; i++) {
            nodeMap.put(i + 1, new Node(i+1));
        }

        for(int i = 0;i < connectionNumber;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            Node nodeA = nodeMap.get(a);
            Node nodeB = nodeMap.get(b);
            nodeA.getAdjacent().add(nodeB);
            nodeB.getAdjacent().add(nodeA);
        }

        List<Node> queue = new ArrayList<>();

        queue.add(nodeMap.get(1));
        int num = 0;
        while(!queue.isEmpty()){
            Node node = queue.remove(0);
            if(!node.isVisited()){
                node.setVisited(true);
                num++;
            }

            for (Node adjacent : node.getAdjacent()) {
                if(!adjacent.isVisited()){
                    queue.add(adjacent);

                }
            }
        }
        System.out.println(num - 1);
    }


    private static class Node{

        private final int data;
        private final List<Node> adjacent = new LinkedList<>();
        private boolean visited;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public List<Node> getAdjacent() {
            return adjacent;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
    }
}