import java.io.*;
import java.util.*;

class Main{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> numbers = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }

        List<Integer> answer = new ArrayList<>();
        int next = 0;
        while (!numbers.isEmpty()){
            next = (next + (K - 1)) % numbers.size();
            answer.add(numbers.remove(next));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int number : answer) {
            sb.append(number).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append(">");
        System.out.print(sb);
    }
}