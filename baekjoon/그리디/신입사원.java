import java.util.*;

public class Main {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int c = 0;
        while(c < cases){
            int n = sc.nextInt();
            ArrayList<int[]> ranks = new ArrayList<>();
            int f, s;
            for(int i = 0;i < n;i++){
                f = sc.nextInt();
                s = sc.nextInt();
                ranks.add(new int[]{f, s});
            }
            
            ranks.sort(((o1, o2) -> o1[0] - o2[0]));

            int ans = 0;
            List<Integer> possible = new ArrayList<>(100000);
            possible.add(ranks.get(0)[1]);
            for(int i = 1;i < n;i++){
                if (ranks.get(i)[1] < possible.get(possible.size() - 1)) {
                    possible.add(ranks.get(i)[1]);
                }
            }
            System.out.println(possible.size());
            c++;
        }
    }
}