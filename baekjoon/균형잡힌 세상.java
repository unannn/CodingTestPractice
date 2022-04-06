import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (!input.equals(".")) {
            List<Character> stack = new LinkedList<>();
            for (int i = 0; i < input.length(); i++) {
                char letter = input.charAt(i);
                if (letter == '(' || letter == '[') {
                    stack.add(0, letter);
                } else if (letter == ')' || letter == ']') {
                    if (stack.isEmpty()) {
                        stack.add(letter);
                        break;
                    }

                    if (stack.get(0) == '(') {
                        if(letter == ')')stack.remove(0);
                        else break;
                    } else if (stack.get(0) == '[' ) {
                        if(letter == ']')stack.remove(0);
                        else break;
                    }
                }
            }
            sb.append(stack.isEmpty() ? "yes\n" : "no\n");
            input = br.readLine();

        }
        System.out.println(sb.toString());
    }
}