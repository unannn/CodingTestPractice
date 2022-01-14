class Solution {
    public long solution(long n) {
        double sqrtN = Math.sqrt(n);
        return sqrtN - (long)sqrtN == 0 ? (long)Math.pow(sqrtN+1,2) : -1;
    }
}