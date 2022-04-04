import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LineOne {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char[] brackets = br.readLine().toCharArray();
            List<Character> stack = new LinkedList<>();
            for (char bracket : brackets) {
                if(bracket == '('){
                    stack.add(bracket);
                }else{
                    if(stack.isEmpty()){
                        stack.add(')');
                        break;
                    }

                    if(stack.get(stack.size() - 1) == '('){
                        stack.remove(stack.size() - 1);
                    }else{
                        stack.add(bracket);
                    }
                }
            }
            sb.append(stack.isEmpty() ? "YES" : "NO").append("\n");
        }
        System.out.println(sb.toString());
    }
}