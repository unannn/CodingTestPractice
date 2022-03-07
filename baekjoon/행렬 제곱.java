import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long b = sc.nextLong();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0;j< n;j++){
                matrix[i][j] = sc.nextInt() % 1000;
            }
        }

        int[][] answer = dac(matrix, b);
        for (int i = 0; i < n; i++) {
            for(int j = 0;j< n;j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] dac(int[][] matrix,long i){
        if(i == 1l){
            return matrix;
        }

        int[][] m = dac(matrix, i / 2);

        m = multiplyMatrix(m, m);
        if(i % 2 == 1) m = multiplyMatrix(m, matrix);

        return m;
    }

    private static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int[][] matrix = new int[a.length][b[0].length];
        int sum;
        for (int i = 0; i < a.length; i++) {
            for(int j = 0;j< b[0].length;j++){
                sum = 0;
                for (int k = 0; k < b.length; k++) {
                    sum += a[i][k] * b[k][j];
                }
                matrix[i][j] = sum  % 1000;
            }
        }
        return matrix;
    }
}