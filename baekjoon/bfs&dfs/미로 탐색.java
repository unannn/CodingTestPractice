import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int tmp;
        int[][] map = new int[n][m];
        int[][] depth = new int[n][m];
        for(int i = 0;i < n;i++){
            String[] temp = sc.nextLine().split("");
            for(int j = 0;j < m;j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        //bfs
        List<Coordinate> q = new ArrayList<>();
        q.add(new Coordinate(0,0));
        depth[0][0] = 1;
        int num = 0;
        while(!q.isEmpty()){
            num++;
            Coordinate coord = q.remove(0);
            Coordinate next = getVisitingNode( map, coord, n, m);
            while(next != null){
                q.add(next);
                map[next.i][next.j] = -1;
                depth[next.i][next.j] = depth[coord.i][coord.j] + 1;
                
                if(next.i == n - 1 && next.j == m - 1){
                    System.out.println(depth[n - 1][m - 1]);
                    return;
                }
                next = getVisitingNode(map, coord, n,m);
            }
        }
    }


    private static Coordinate getVisitingNode(int[][] map,Coordinate coordinate, int n, int m){
        int x = coordinate.i;
        int y = coordinate.j;

        if(x-1 >= 0){
            if(map[x - 1][y] == 1){
                return new Coordinate(x - 1, y);
            }
        }

        if(x + 1 < n){
            if(map[x + 1][y] == 1){
                return new Coordinate(x + 1, y);
            }
        }

        if(y - 1 >= 0){
            if(map[x][y - 1] == 1){
                return new Coordinate(x, y - 1);
            }
        }

        if(y + 1 < m){
            if(map[x][y + 1] == 1){
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