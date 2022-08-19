import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      int[] times = new int[N];
      for(int i = 0; i < N;i++) {
         times[i] = Integer.parseInt(br.readLine());
      }
      System.out.println(solution(M, times));
   }

   public static long solution(int n, int[] times) {
      long answer = 0;

      long start = 0;
      long end = 0;
      for (int i = 0; i < times.length; i++) {
         end = Math.max(end, times[i]);
      }
      end = end * n;
        
      while (start <= end) {

         long mid = (start + end) / 2;
         long sum = 0;
         
         for (int i = 0; i < times.length; i++) {
            sum += mid / times[i];
         }

         if (sum >= n) {
            answer = mid;
            end = mid - 1;
         } else {
            start = mid + 1;
         }
      }

      return answer;
   }
}
