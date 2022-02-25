class Solution {
    public int[] solution(int brown, int yellow) {
        
        int width = 3 , height = 3;
        for(int i = 1; i < brown / 2 ; i++){
            width = brown / 2 - i;
            if(yellow == ((width - 2) * i)) {
                height = i + 2;
                break;
            }
        }
        
        return new int[]{width, height};
    }
}