import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        Integer[] B = new Integer[n];
        for(int i = 0;i < n;i++){
            A[i] = sc.nextInt();
        }
        for(int i = 0;i < n;i++){
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B, Comparator.reverseOrder());
        int sum = 0;
        for(int i = 0;i < n;i++){
            sum += A[i] * B[i];
        }
        System.out.println(sum);
    }
}