import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> coords = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] c = new int[2];
            c[0] = Integer.parseInt(st.nextToken());
            c[1] = Integer.parseInt(st.nextToken());
            coords.add(c);
        }

        StringBuilder sb = new StringBuilder();
        coords.stream().
                sorted((o1, o2) -> {
                    if(o1[1] == o2[1]) return o1[0] - o2[0];
                    return o1[1] - o2[1];
                })
                .forEach(o -> sb.append(o[0] + " " + o[1]).append('\n'));

        System.out.println(sb);
    }
}