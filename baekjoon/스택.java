import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Integer> stack = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    int X = Integer.parseInt(st.nextToken());
                    stack.add(X);
                    break;

                case "pop":
                    sb.append(stack.isEmpty() ? -1 : stack.remove(stack.size() - 1)).append('\n');
                    break;

                case "size":
                    sb.append(stack.size()).append('\n');
                    break;

                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append('\n');
                    break;

                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.get(stack.size() - 1)).append('\n');
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}