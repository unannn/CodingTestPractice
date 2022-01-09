class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder(phone_number);
        for(int index = 0;index < phone_number.length() - 4;index++){
            sb.replace(index,index+1,"*");
        }
        return sb.toString();
    }
}