import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    sb.append(deque.isEmpty() ? -1 : deque.removeFirst()).append('\n');
                    break;

                case "pop_back":
                    sb.append(deque.isEmpty() ? -1 : deque.removeLast()).append('\n');
                    break;

                case "size":
                    sb.append(deque.size()).append('\n');
                    break;

                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append('\n');
                    break;

                case "front":
                    Integer first = deque.peekFirst();
                    sb.append(first == null ? -1 : first).append('\n');
                    break;

                case "back":
                    Integer last = deque.peekLast();
                    sb.append(last == null ? -1 : last).append('\n');
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}