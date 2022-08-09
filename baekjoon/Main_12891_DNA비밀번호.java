import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		char[] str = br.readLine().toCharArray();

		char[] genes = {'A','C','G','T'};
		int[] geneLimit = new int[4];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0;i < 4;i ++) {
			geneLimit[i] =  Integer.parseInt(st.nextToken());
		}

		//numberMap에 각 문자의 개수 0으로 초기화
		int[] numbers = new int['Z' - 'A' + 1];
		//맨앞 부분문자열에서 각 문자의 개수 numberMap 에 저장
		for(int i = 0; i < P; i++) {
			numbers[str[i] - 'A']++;
		}
		
		
		//맨앞 부분문자열이 암호 조건을 만족하는지 체크
		int answer = 0;
		for(int i = 0; i < 4;i++) {
			if(geneLimit[i] > numbers[genes[i] - 'A']) {
				answer--;
				break;
			}
		}
		answer++;

		for(int i = 1; i < S - P + 1; i++) {
			
			char prev = str[i - 1];
			char next = str[i + P - 1];
			//이전 단어 뺴주기
			numbers[prev - 'A']--;
			//다음 다어 더해주기
			numbers[next - 'A']++;

			for(int j = 0; j < 4;j++) {
				if(geneLimit[j] > numbers[genes[j] - 'A']) {
					answer--;
					break;
				}
			}
			answer++;
		}
		System.out.println(answer);
	}
}