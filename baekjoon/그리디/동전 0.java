import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int price = sc.nextInt();
        int[] types = new int[n];
        for(int i = 0;i < n;i++){
            types[i] = sc.nextInt();
        }

        int i;
        for(i = n - 1;i >= 0;i--){
            if(types[i] <= price) break;
        }

        int num = 0;
        while(i >= 0){
            if(price - types[i] < 0){
                i--;
            }else if(price - types[i] > 0){
                price -= types[i];
                num++;
            }else{
                num++;
                break;
            }
        }
        System.out.println(num);
    }
}