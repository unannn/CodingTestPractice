import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            deque.add(i + 1);
        }

        while(deque.size() > 1){
            deque.remove();
            deque.add(deque.remove());
        }
        System.out.println(deque.remove());
    }
}