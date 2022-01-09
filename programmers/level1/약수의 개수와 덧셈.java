import java.util.ArrayList;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int index = left;index<= right;index++){
            if(getDivisors(index).size() % 2 == 0){ answer += index;}
            else{answer -= index;}
        }
        return answer;
    }

    private ArrayList<Integer> getDivisors(int number){
        ArrayList<Integer> divisors = new ArrayList<>();
        double numberSqrt = Math.sqrt(number);
        for(int index = 1;index <= numberSqrt;index++){
            if(number % index == 0){
                if(!divisors.contains(index)){divisors.add(index);}
                if(!divisors.contains(number / index)){ divisors.add(number / index);}
            }
        }
        return divisors;
    }
}