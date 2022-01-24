import java.util.*;

class Solution {
    public int solution(int n) {
        boolean[] isPrimeArray = new boolean[n+1];
        Arrays.fill(isPrimeArray,true);
        isPrimeArray[0] = false;
        isPrimeArray[1] = false;

        for(int i = 2;i*i <= n;i++){
            if(isPrimeArray[i]){
                for(int j = i*i;j <= n;j+=i){
                    isPrimeArray[j] = false;
                }
            }
        }
        return getPrimeNumber(isPrimeArray);
    }

    private int getPrimeNumber(boolean[] isPrimeArray) {
        int number =0;
        for (boolean isPrime : isPrimeArray) {
            number += isPrime ? 1 : 0;
        }
        return number;
    }
}