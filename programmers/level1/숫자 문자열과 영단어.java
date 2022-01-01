class Solution {
    public int solution(String s) {
        int num = 0;
        String[] numberWords = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(String word : numberWords){
            if(s.contains(word)){
                s = s.replace(word,String.valueOf(num));
            }
            num++;
        }

        return Integer.parseInt(s);
    }
}