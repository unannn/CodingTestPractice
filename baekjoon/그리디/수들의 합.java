import java.util.*;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 0;
        long i = 0;
        while(sum <= n){
            i++;
            sum += i;
        }
        System.out.println(i - 1);
    }
}