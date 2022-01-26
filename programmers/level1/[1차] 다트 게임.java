import java.util.*;
class Solution {

    final static Map<Character, Integer> bonusMap = Map.of(
            'S', 1,
            'D', 2,
            'T', 3
    );

    public int solution(String dartResult) {
        List<Phase> phases = new ArrayList<>();
        int index = 0;
        while(index < dartResult.length()){
            Phase phase = new Phase();
            phases.add(phase);

            //점수
            if(dartResult.substring(index, index + 2).contains("10")){
                phase.setScore(10);
                index += 2;
            }
            else{
                phase.setScore(dartResult.charAt(index) - '0');
                index++;
            }
            if(index >= dartResult.length()) break;

            //보너스
            phase.setBonus(dartResult.charAt(index));
            index++;
            if(index >= dartResult.length()) break;

            //옵션
            if(!Character.isDigit(dartResult.charAt(index))){
                phase.setOption(dartResult.charAt(index));
                index++;
            }
            else{
                phase.setOption('\0');
            }
            if(index >= dartResult.length()) break;
        }

        //보너스 처리
        for (int i = 0; i < phases.size(); i++) {
            Phase phase = phases.get(i);
            if(phase.getOption() == '*'){
                phase.setOptionNumber(2);
                if(i != 0){
                    phases.get(i - 1).setOptionNumber(2);
                }
            }
            else if (phase.getOption() == '#'){
                phase.setOptionNumber(-1);
            }
        }

        int answer = 0;
        for (Phase phase : phases) {
            answer += phase.calculateTotalScore();
        }

        return answer;
    }

    static class Phase{
        private int score;
        private char bonus;
        private char option;
        private int optionNumber;

        public Phase() {
            optionNumber = 1;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public void setBonus(char bonus) {
            this.bonus = bonus;
        }

        public char getOption() {
            return option;
        }

        public void setOption(char option) {
            this.option = option;
        }

        public void setOptionNumber(int optionNumber) {
            this.optionNumber *= optionNumber;
        }

        public int calculateTotalScore(){
            return this.optionNumber * (int)Math.pow(this.score, bonusMap.get(this.bonus));
        }
    }
}