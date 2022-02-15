import java.util.*;

class Solution {
   public int[] solution(int n, String[] words) {
        int round = 1;
        int order = 1;
        char nextLetter = words[0].charAt(0);
        Set<String> usedWords = new HashSet<>();
        for (String word : words) {
            if(word.charAt(0) != nextLetter){
                return new int[]{order, round};
            }
            if(usedWords.contains(word)){
                return  new int[]{order, round};
            }

            usedWords.add(word);
            nextLetter = word.charAt(word.length() - 1);
            round = order == n ? round + 1 : round;
            order = order == n ? 1 : order + 1;
        }

        return new int[]{0,0};
    }
}