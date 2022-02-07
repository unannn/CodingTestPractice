class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if(n % 3 == 0){
                sb.insert(0, 4);
                if(n == 3) break;
                n = n / 3 - 1;
            }
            else{
                sb.insert(0,n % 3);
                n /= 3;
            }
        }

        return sb.toString();
    }
}