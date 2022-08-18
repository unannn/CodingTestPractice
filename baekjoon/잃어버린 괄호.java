import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] stringNumbers = str.split("[+-]");

        int[] numbers = new int[stringNumbers.length];
        for(int i = 0; i < numbers.length;i++){
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }

        char[] signs = new char[numbers.length];
        signs[0] = '+';
        int signIdx = 1;

        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if (chars[i] == '+' || chars[i] == '-') {
                signs[signIdx++] = chars[i];
            }
        }
        
        int sum = 0;
        int sign = 1;
        for(int i = 0; i < numbers.length; i++){
            if(signs[i] == '-') sign = -1;
            sum += numbers[i] * sign;
        }
        System.out.println(sum);
    }
}