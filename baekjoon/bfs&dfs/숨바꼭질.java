import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        List<Integer> queue = new LinkedList<>();
        int[] visits = new int[100001];
        visits[a] = 1;
        queue.add(a);
        while(!queue.isEmpty()){
            Integer poll = queue.remove(0);
            if(poll == b){
                System.out.println(visits[poll] - 1);
                return;
            }

            int[] cases = {poll - 1 , poll  + 1, poll * 2};
            for(int i = 0;i < 3;i++){
                if(cases[i] >= 0 && cases[i] <= 100000 && visits[cases[i]] == 0){
                    queue.add(cases[i]);
                    visits[cases[i]] = visits[poll] + 1;
                }
            }
        }
    }
}