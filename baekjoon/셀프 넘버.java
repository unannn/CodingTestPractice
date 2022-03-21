public class Main {
    public static void main(String[] args) {
        boolean[] isNotSelfNumbers = new boolean[10001];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10001; i++) {
            int number = calculate(i);
            if(number <= 10000){
                isNotSelfNumbers[number] = true;
            }
        }

        for (int i = 1; i < isNotSelfNumbers.length; i++) {
            if(!isNotSelfNumbers[i]) sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int calculate(int n) {
        int sum = n;
        while(n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}