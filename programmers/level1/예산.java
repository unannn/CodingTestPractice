class Solution {
    public int solution(int[] d, int budget) {
        int tmp;
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length - i - 1; j++) {
                if(d[j] > d[j+1]){
                    tmp = d[j];
                    d[j] = d[j + 1];
                    d[j + 1] = tmp;
                }
            }
        }

        int number = 0;
        while(number < d.length){
            budget -= d[number];
            if(budget < 0){break;}
            number++;
        }
        return number;
    }
}