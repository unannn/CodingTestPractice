import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder stars = new StringBuilder("");
        for (int index = 0; index < a; index++) {
            stars.append('*');
        }

        for(int index = 0; index < b; index++){
            System.out.println(stars);
        }
    }
}