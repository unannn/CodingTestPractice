import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> strs = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            strs.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        strs.stream()
                .sorted((o1, o2) -> {
                    if(o1.length() != o2.length()) {
                        return o1.length() - o2.length();
                    }
                    else{
                        return o1.compareTo(o2);
                    }})
                .forEach( str -> sb.append(str).append('\n'));
        System.out.println(sb);
    }
}