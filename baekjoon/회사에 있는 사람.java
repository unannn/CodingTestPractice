import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> employees = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();
            if (log.equals("enter")) {
                employees.add(name);
            }else{
                employees.remove(name);
            }
        }

        employees.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}

}
