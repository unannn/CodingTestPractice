import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] score = br.readLine().split(":");
        int N = Integer.parseInt(score[0]);
        int M = Integer.parseInt(score[1]);

        int gcd = gcd(N, M);
        System.out.println((N/gcd) +":"+(M/gcd));

    }

    private static int gcd(int a, int b){
        if (b == 0) {
            return a;
        }
        else{
            return gcd(b, a % b);
        }
    }
}