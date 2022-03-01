import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String formula = sc.nextLine();
        String[] numbers = formula.split("[+-]");
        char[] signs = new char[numbers.length];
        signs[0] = '+';
        int j = 1;
        for (int i = 0; i < formula.length(); i++) {
            if(formula.charAt(i) == '+' || formula.charAt(i) == '-'){
                signs[j++] = formula.charAt(i);
            }
        }

        List<Integer> q = new ArrayList<>();
        j = 0;
        int sum = 0;
        boolean isFirst = true;
        for (int i = 0; i < numbers.length;i++) {
            if(signs[i] == '-'){
                int temp = 0;
                while(!q.isEmpty()){
                    temp += q.remove(0);
                }
                if(isFirst){
                    sum += temp;
                    isFirst = false;
                }else{
                    sum -= temp;
                }
            }
            q.add(Integer.parseInt(numbers[i]));
        }
        
        while(!q.isEmpty()){
            if(isFirst){
                sum += q.remove(0);
            } else{
                sum -= q.remove(0);
            }
        }
        
        System.out.println(sum);
    }
}