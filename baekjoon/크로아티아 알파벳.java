import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] alphabets = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s = br.readLine().toCharArray();

        int answer = s.length;
        for (int i = 0, size = s.length; i < size; i++) {
            for (String alphabet : alphabets) {
                if (i + alphabet.length() - 1 < size) {
                    char[] a = alphabet.toCharArray();

                    int j;
                    for (j = 0; j < a.length; j++) {
                        if (a[j] != s[i + j]) break;
                    }

                    if (j == a.length) {
                        i += alphabet.length() - 1;
                        answer -= alphabet.length() - 1;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}