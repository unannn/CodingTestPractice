import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ropes = new int[n];
        for(int i = 0;i < n;i++){
            ropes[i] = sc.nextInt();
        }
        Arrays.sort(ropes);
        int max = ropes[0] * n;
        for(int i = 1;i < n;i++){
            int w = ropes[i] * (n - i);
            if(max < w){
                max = w;
            }
        }
        System.out.println(max);
    }
}