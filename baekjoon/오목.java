import java.io.*;
import java.util.*;

public class Main {

	private static final int L = 19;
	private static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
	private static int[] dy = {1, 0, -1, 1, 0, -1, 1, -1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int[][] board = new int[L][L];
		
		int[][] locations = new int[L*L][2];
		int dollNum = 0;
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < L; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] > 0) {
					locations[dollNum][0] = i;
					locations[dollNum][1] = j;
					dollNum++;
				}
			}
		}
		
		//바둑돌의 좌표가 담긴 배열의 길이가 19 * 19 이므로, 좌표의 개수(놓여진 돌의 개수)인 dollNum의 크기로 변환
		locations = Arrays.copyOf(locations, dollNum);

		//가장 왼쪽의 좌표부터 조사하기 위한 세로 탐색을 위해 column 기준으로 탐색할 좌표 정렬
		Arrays.sort(locations,(o1, o2) -> o1[1] - o2[1]);
		
		for(int i = 0; i < dollNum; i++) {
			int x = locations[i][0];
			int y = locations[i][1];
			
			int type = board[x][y];
			for(int j = 0; j < 8;j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				int count = 1;
				while(isPossibleLocation(L,nx,ny) && board[nx][ny] == type) {
					count++;
					nx += dx[j];
					ny += dy[j];
				}
				
				if(count == 5) {
					//반대 방향 체크
					int tx = x - dx[j];
					int ty = y - dy[j];
					//바둑알을 놓을 수 없는 위치 또는 놓을 수 있는 위치이지만 돌이 놓여있지 않거나 종류가 다를 때 5개의 돌이 연속적으로 놓여있다고 할 수 있음 
					if(!isPossibleLocation(L, tx, ty) || board[tx][ty] != type) {
						System.out.println(type);
						System.out.println((x + 1) +" "+ (y + 1));
						return;
					}
				}
			}
		}
		
		System.out.println(0);
	}
	
	private static boolean isPossibleLocation(int N, int x, int y) {
		return (x >= 0 && x < N) && (y >= 0 && y < N);
	}
}
import java.io.*;
import java.util.*;

public class Main {

	private static final int L = 19;
	private static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
	private static int[] dy = {1, 0, -1, 1, 0, -1, 1, -1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int[][] board = new int[L][L];
		
		int[][] locations = new int[L*L][2];
		int dollNum = 0;
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < L; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] > 0) {
					locations[dollNum][0] = i;
					locations[dollNum][1] = j;
					dollNum++;
				}
			}
		}
		
		//바둑돌의 좌표가 담긴 배열의 길이가 19 * 19 이므로, 좌표의 개수(놓여진 돌의 개수)인 dollNum의 크기로 변환
		locations = Arrays.copyOf(locations, dollNum);

		//가장 왼쪽의 좌표부터 조사하기 위한 세로 탐색을 위해 column 기준으로 탐색할 좌표 정렬
		Arrays.sort(locations,(o1, o2) -> o1[1] - o2[1]);
		
		for(int i = 0; i < dollNum; i++) {
			int x = locations[i][0];
			int y = locations[i][1];
			
			int type = board[x][y];
			for(int j = 0; j < 8;j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				int count = 1;
				while(isPossibleLocation(L,nx,ny) && board[nx][ny] == type) {
					count++;
					nx += dx[j];
					ny += dy[j];
				}
				
				if(count == 5) {
					//반대 방향 체크
					int tx = x - dx[j];
					int ty = y - dy[j];
					//바둑알을 놓을 수 없는 위치 또는 놓을 수 있는 위치이지만 돌이 놓여있지 않거나 종류가 다를 때 5개의 돌이 연속적으로 놓여있다고 할 수 있음 
					if(!isPossibleLocation(L, tx, ty) || board[tx][ty] != type) {
						System.out.println(type);
						System.out.println((x + 1) +" "+ (y + 1));
						return;
					}
				}
			}
		}
		
		System.out.println(0);
	}
	
	private static boolean isPossibleLocation(int N, int x, int y) {
		return (x >= 0 && x < N) && (y >= 0 && y < N);
	}
}
