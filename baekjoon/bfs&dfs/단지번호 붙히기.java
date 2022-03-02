import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int tmp;
        int[][] map = new int[n][n];
        for(int i = 0;i < n;i++){
            String[] temp = sc.nextLine().split("");
            for(int j = 0;j < n;j++){
                map[i][j] = -1 * Integer.parseInt(temp[j]);
            }
        }

        List<Integer> areas = new ArrayList<>();
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(map[i][j] == -1){
                    //로직
                    int sum = dfs(map, new Coordinate(i, j), n, 1);
                    areas.add(sum);
                }
            }
        }

        //답 출력
        System.out.println(areas.size());
        areas.sort((o1, o2) -> o1 - o2);
        for(Integer area : areas){
            System.out.println(area);
        }
    }

    private static int dfs(int[][] map,Coordinate coordinate, int n, int sum){
        map[coordinate.i][coordinate.j] = 1;
        Coordinate next = getVisitingHouse(map, coordinate, n);
        if(next == null){
            return sum;
        }else{
//            int s = 0;
            while(next != null && map[next.i][next.j] != 1){
                sum = dfs(map, next, n,  sum + 1);
                next = getVisitingHouse(map, coordinate, n);
            }
            return sum;
        }
    }

    private static Coordinate getVisitingHouse(int[][] map,Coordinate coordinate, int n){
        int x = coordinate.i;
        int y = coordinate.j;

        if(x-1 >= 0){
            if(map[x - 1][y] == -1){
                return new Coordinate(x - 1, y);
            }
        }

        if(x + 1 < n){
            if(map[x + 1][y] == -1){
                return new Coordinate(x + 1, y);
            }
        }

        if(y - 1 >= 0){
            if(map[x][y - 1] == -1){
                return new Coordinate(x, y - 1);
            }
        }

        if(y + 1 < n){
            if(map[x][y + 1] == -1){
                return new Coordinate(x, y + 1);
            }
        }

        return null;
    }

    private static class Coordinate{

        private int i;
        private int j;

        public Coordinate(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}