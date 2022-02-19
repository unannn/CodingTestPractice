class Solution {
    public int[] solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i, round = 0,number = 0;
        while(!sb.toString().equals("1")){
            i = 0;
            round++;
            while(sb.length() > i){
                if(sb.charAt(i) == '0'){
                    sb.deleteCharAt(i);
                    number++;
                }
                else{
                    i++;
                }
            }
            sb = new StringBuilder(getBinary(sb.length()));
        }
        return new int[]{round, number};
    }

    private String getBinary(int number){
        StringBuilder binary = new StringBuilder();
        while(number > 0){
            binary.insert(0, number % 2 == 0 ? '0' : '1');
            number /= 2;
        }
        return binary.toString();
    }
}