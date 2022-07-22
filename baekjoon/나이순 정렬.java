import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Member> members = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			members.add(new Member(i, Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		members.stream()
			.sorted((o1,o2)->{
				if(o1.age != o2.age) {
					return o1.age - o2.age;
				}
				return o1.no - o2.no;
			})
			.forEach(o1 -> System.out.println(o1.age + " " +o1.name));
	}
	
	static class Member{
		int no;
		int age;
		String name;
		public Member(int no, int age, String name) {
			this.no = no;
			this.age = age;
			this.name = name;
		}
	}
}
