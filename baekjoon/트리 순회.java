import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static class Node{
        String element;
        Node left;
        Node right;

        public Node(String element){
            this.element = element;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Node> tree = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            Node[] nodes = new Node[3]; //객체 배열선언시 default는 null

            for(int j = 0;j < 3;j++){
                String element = st.nextToken();

                if(!element.equals(".")){
                    nodes[j] = findNode(tree,element);
                    if(nodes[j] == null){
                        nodes[j] = new Node(element);
                        tree.add(nodes[j]);
                    }
                }
            }

            nodes[0].left = nodes[1];
            nodes[0].right = nodes[2];

        }

        preorder(tree.get(0));
        System.out.println();
        inorder(tree.get(0));
        System.out.println();
        postorder(tree.get(0));

    }

    public static Node findNode(List<Node> tree, String element){
        for (Node node : tree) {
            if(node.element.equals(element)) {
                return node;
            }
        }
        return null;
    }

    public static void preorder(Node rt){
        if(rt==null) return;
        System.out.print(rt.element);//visit
        preorder(rt.left);
        preorder(rt.right);
    }

    public static void inorder(Node rt){
        if(rt==null) return;
        inorder(rt.left);
        System.out.print(rt.element); //visit
        inorder(rt.right);
    }

    public static void postorder(Node rt){
        if(rt==null) return;
        postorder(rt.left);
        postorder(rt.right);
        System.out.print(rt.element); //visit
    }
}