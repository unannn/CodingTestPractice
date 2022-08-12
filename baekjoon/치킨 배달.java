import java.io.*;
import java.util.*;

public class Main {
	
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][]	map = new int[N][N];
		
		List<Home> homes = new ArrayList<>();
		Chicken[] chickenArray = new Chicken[13];
		
		int chickCount = 0;
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) homes.add(new Home(i, j));
				else if(map[i][j] == 2) {
					Chicken c = new Chicken(i, j);
					chickenArray[chickCount++] = new Chicken(i, j);
				}
			}
		}
		chickenArray = Arrays.copyOf(chickenArray, chickCount);
		
		combination(homes, chickenArray, new ArrayList<Chicken>(), M, 0);

		System.out.println(answer);
	}
	
	private static void combination(List<Home> homes, Chicken[] chickenArray, List<Chicken> chickens, int M, int start) {
		if(chickens.size() == M) {
			
			for(Home home : homes) {
					home.setChickens(chickens);
			}
			
			int chickenDistance = homes.stream().mapToInt(o -> o.minDistance).sum();
			
			answer = Math.min(answer, chickenDistance);
			return;
		}
		
		for(int i = start; i < chickenArray.length; i++) {
			chickens.add(chickenArray[i]);
			combination(homes, chickenArray, chickens, M, i + 1);
			chickens.remove(chickens.size() - 1);
		}
		
	}
	
	static class Home{
		int x;
		int y;
		Chicken min;
		int minDistance;
		List<Chicken> chickens;
		
		public Home(int x, int y) {
			this.x = x;
			this.y = y;
			chickens = new ArrayList<>();
		}
		
		void setChickens(List<Chicken> chickens) {
			this.chickens.clear();
			this.chickens.addAll(chickens);

			this.min= this.chickens.stream()
					.min((o1, o2) -> getChickenDistance(o1) - getChickenDistance(o2))
					.get(); 
			this.minDistance = getChickenDistance(min);
		}
		
		private int getChickenDistance(Chicken chicken) {
			return Math.abs(this.x - chicken.x) + Math.abs(this.y - chicken.y);
		}
	}
	
	static class Chicken{
		int x;
		int y;
		
		public Chicken(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}