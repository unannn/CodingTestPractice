import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int answer = 0;
        for(int i = 1;i <= N;i++){
            int t = i;

            int prev = t % 10;
            t /= 10;
            int curr = t % 10;
            int sub = prev - curr;
            while(t > 0){
                prev = t % 10;
                t /= 10;
                curr = t % 10;
                if(prev - curr != sub) break;
            }

            if(t == 0){
                answer++;
            }
        }
 
        System.out.println(answer);
    }
}