import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        Integer[] numbers = new Integer[str.length()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        Arrays.sort(numbers, (o1,o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }
        System.out.println(sb.toString());
    }
}