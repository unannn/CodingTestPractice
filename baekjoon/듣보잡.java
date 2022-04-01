import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new LinkedHashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N+M; i++) {
            String name = br.readLine();
            if(set.contains(name)){
                list.add(name);
            }else{
                set.add(name);
            }
        }
        
        list.sort(String::compareTo);
        
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}