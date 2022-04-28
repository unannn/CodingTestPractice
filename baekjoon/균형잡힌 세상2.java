import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = br.readLine()).equals(".")) {
            Deque<Character> stack = new ArrayDeque<>();
            int i;
            for (i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '(' || c == '[') {
                    stack.add(c);
                }else if(c == ')'){
                    if(!stack.isEmpty() && stack.peekLast() == '('){
                        stack.removeLast();
                    }else{
                        sb.append("no").append('\n');
                        break;
                    }
                }
                else if(c == ']'){
                    if(!stack.isEmpty() && stack.peekLast() == '['){
                        stack.removeLast();
                    }else{
                        sb.append("no").append('\n');
                        break;
                    }
                }
            }
            if(i == line.length()) {
                if(stack.isEmpty()){
                    sb.append("yes").append('\n');
                }else{
                    sb.append("no").append('\n');
                }
            }
        }
        System.out.println(sb.toString());
    }
}