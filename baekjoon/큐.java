import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    int X = Integer.parseInt(st.nextToken());
                    queue.add(X);
                    break;

                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.remove(0)).append('\n');
                    break;

                case "size":
                    sb.append(queue.size()).append('\n');
                    break;

                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;

                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.get(0)).append('\n');
                    break;

                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.get(queue.size() - 1)).append('\n');
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}