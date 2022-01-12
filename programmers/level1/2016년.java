class Solution {
    public String solution(int a, int b) {
        String[] dayOfWeek = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] monthDay = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = b;
        for(int month = 0; month < a - 1;month++){
            days += monthDay[month];
        }
        return dayOfWeek[days % 7];
    }
}