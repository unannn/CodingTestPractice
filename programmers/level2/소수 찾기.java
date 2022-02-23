import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> numberSet = new HashSet<>();
        char[] numberCharArray = numbers.toCharArray();

        //모든 경우의 수
        for(int i = 1 ; i <= numberCharArray.length ; i++){
            numberSet.addAll(getPermutationNumbers(numberCharArray, i));
        }
        //소수 필터링
        int answer = 0;
        for(Integer number : numberSet){
            if(isPrime(number)) answer++;
        }
        return answer;
    }

    private Set<Integer> getPermutationNumbers(char[] arr, int r){
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0, arrLength = arr.length; i < arrLength; i++) {
            boolean[] isVisited = new boolean[arr.length];
            isVisited[i] = true;
            perm(arr, isVisited, numbers, String.valueOf(arr[i]), 1, r);
        }
        System.out.println(numbers);
        return numbers;
    }

    private void perm(char[] arr, boolean[] isVisited, Set<Integer> numbers, String out, int level, int r){
        if(level == r){
            numbers.add(Integer.valueOf(out));
            return;
        }

        for(int i = 0; i < arr.length;i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                perm(arr, isVisited, numbers, out + arr[i], level + 1, r);
                isVisited[i] = false;
            }
        }
    }

    private boolean isPrime(int number){
        if(number == 0 || number == 1) return false;
        for(int i = 2;i <= Math.sqrt(number);i++){
            if(number % i == 0) return false;
        }
        System.out.println(number);
        return true;
    }
}