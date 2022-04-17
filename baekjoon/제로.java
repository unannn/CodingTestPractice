import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        List<Integer> stack = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number != 0) {
                sum += number;
                stack.add(number);
            } else {
                sum -= stack.remove(stack.size() - 1);
            }
        }
        System.out.println(sum);
    }
}