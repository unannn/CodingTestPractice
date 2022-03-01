import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int sum = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            answer += sum;
        }
        System.out.println(answer);
    }
}