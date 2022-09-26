import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] alphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s = br.readLine().toCharArray();

        int answer = s.length;
        for (String alphabet : alphabets) {
            char[] a = alphabet.toCharArray();
            int temp = 0;
            for(int i = 0; i < s.length - a.length + 1; i++){
                int same = 0;
                for(int j = 0; j < a.length; j++){
                    same += a[j] == s[i+j] ? 1 : 0;
                }
                temp += same == a.length ? 1 : 0;
            }

            answer -= (a.length - 1)* temp;
        }
        System.out.println(answer);
    }
}
