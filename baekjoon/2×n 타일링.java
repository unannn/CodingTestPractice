import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] square = new int[N + 1];
        square[1] = 1;
        if(N >= 2)square[2] = 2;


        for (int i = 3; i <= N; i++) {
            square[i] = (square[i - 1]  + square[i - 2]) % 10007;
        }
        System.out.println(square[N]);
    }
}