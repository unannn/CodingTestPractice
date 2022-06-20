import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {

    private final static int[] dx = {1, 0, -1, 0};
    private final static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Node[] tree = new Node[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new Node(i);
        }

        Node root= null;
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = tree[i];
            }else{
                tree[parent].connect(tree[i]);
            }
        }

        int K = Integer.parseInt(bf.readLine());

        tree[K].delete();

        int count = 0;
        Deque<Node> stack = new ArrayDeque<>();
        stack.add(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node.childs.size() == 0){ //리프노드면 개수 추가
                count++;
                continue;
            }

            List<Node> childs = node.childs;
            for (Node child : childs) {
                stack.push(child);
            }
        }

        System.out.println(count);
    }

    static class Node{

        private Node parent;
        private int number;
        private List<Node> childs;

        public Node(int number) {
            this.number = number;
            this.childs = new ArrayList<>();
        }

        private void connect(Node child){
            this.childs.add(child);
            child.parent = this;
        }

        private void delete(){
            if(parent == null){
                System.out.println(0);
                exit(1);
            }

            this.parent.childs.remove(this);
        }
    }
}