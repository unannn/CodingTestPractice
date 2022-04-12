import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> bookMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String bookName = br.readLine();
            if(bookMap.containsKey(bookName)){
                bookMap.replace(bookName, bookMap.get(bookName) + 1);
            }else{
                bookMap.put(bookName, 1);
            }
        }

        String answer = "";
        int count = 0;
        Set<String> keySet = bookMap.keySet();
        for (String key : keySet) {
            int bookNumber = bookMap.get(key);
            if (bookNumber > count) {
                answer = key;
                count = bookNumber;
            }
        }
        System.out.println(answer);
    }
}