class Solution {
    public int solution(long num) {
        for(int i = 0;i < 501;i++){
            if(num == 1) {
                return i;
            }

            if(num % 2 == 0){
                num /= 2;
            }
            else{
                num = num * 3 + 1;
            }
        }
        return -1;
    }
}