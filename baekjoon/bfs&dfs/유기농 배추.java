import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testNumber = sc.nextInt();
        for(int test = 0;test < testNumber;test++){
            int M = sc.nextInt();
            int N = sc.nextInt();
            int[][] board = new int[N][M];
            int cabbageNumber = sc.nextInt();
            int x,y;
            for(int i = 0;i < cabbageNumber;i++){
                x = sc.nextInt();
                y = sc.nextInt();
                board[y][x] = 1;
            }

            int num = 0;
            for(int i = 0; i < N;i++){
                for(int j = 0;j < M;j++){
                    if(board[i][j] == 1){
                        List<Coordinate> q = new ArrayList<>();
                        num++;
                        q.add(new Coordinate(j, i));
                        board[i][j] = -1;
                        while(!q.isEmpty()){

                            Coordinate coordinate = q.remove(0);
                            Coordinate next = getVisitingHouse(board, coordinate, M, N);

                            while(next != null){
                                if(board[next.y][next.x] == 1)q.add(next);

                                board[next.y][next.x] = -1;
                                next = getVisitingHouse(board, coordinate, M, N);
                            }
                        }
                    }
                }
            }
            System.out.println(num);
        }
    }

    private static Coordinate getVisitingHouse(int[][] board,Coordinate coordinate, int M, int N){

        int x = coordinate.x;
        int y = coordinate.y;

        if(x-1 >= 0){
            if(board[y][x - 1] == 1){
                return new Coordinate(x - 1, y);
            }
        }

        if(x + 1 < M){
            if(board[y][x + 1] == 1){
                return new Coordinate(x + 1, y);
            }
        }

        if(y - 1 >= 0){
            if(board[y - 1][x] == 1){
                return new Coordinate(x, y - 1);
            }
        }

        if(y + 1 < N){
            if(board[y + 1][x] == 1){
                return new Coordinate(x, y + 1);
            }
        }

        return null;
    }

    private static class Coordinate{

        private int x;
        private int y;

        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}