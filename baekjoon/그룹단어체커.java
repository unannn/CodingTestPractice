import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        boolean[] groupChecker = new boolean[26];
        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            answer++;
            char prev = temp[0];
            groupChecker[temp[0] - 'a'] = true;
            for (int j = 1, size = temp.length; j < size; j++) {
                if (!groupChecker[temp[j] - 'a']) {
                    groupChecker[temp[j] - 'a'] = true;
                    prev = temp[j];
                } else {
                    if (prev != temp[j]) {
                        answer--;
                        break;
                    }
                }
            }
            Arrays.fill(groupChecker, false);
        }
        System.out.println(answer);
    }
}