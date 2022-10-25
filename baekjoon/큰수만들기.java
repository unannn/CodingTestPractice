import java.util.*;
import java.io.*;

public class Main {
        
    public static void main(String[] args) throws Exception{        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[] strs = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N;i++){
            strs[i] = st.nextToken();
        }
        
        Arrays.sort(strs, (o1, o2)->{
            String a = o1 + o2;
            String b = o2 + o1;
            return b.compareTo(a);
        });
                
        if(strs[0].equals("0")) {
            System.out.println(0);  
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
        }
        
        System.out.println(sb.toString());  
    }
}
