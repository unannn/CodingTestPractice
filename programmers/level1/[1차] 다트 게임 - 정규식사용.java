import java.util.*;
class Solution {

    public int solution(String dartResult) {
        String[] results = dartResult.split("(?=10|[1-9]|(?<!1)0)");
        List<Phase> phases = new ArrayList<>();
        for (String result : results) {
            String[] resultToken = result.split("(?<=10|[02-9]|1(?!0)|(?=[*#]))");
            Phase phase = new Phase();
            phase.setScore(Integer.parseInt(resultToken[0]));
            phase.setBonus(resultToken[1].charAt(0));
            if(resultToken.length == 3) phase.setOption(resultToken[2].charAt(0));

            phases.add(phase);
        }

        for (int i = 0; i < phases.size(); i++) {
            Phase phase = phases.get(i);
            if(phase.getOption() == '*'){
                phase.setOptionNumber(2);
                if(i != 0){
                    phases.get(i - 1).setOptionNumber(2);
                }
            }
            else if(phase.getOption() == '#'){
                phase.setOptionNumber(-1);
            }
        }

        return phases.stream().mapToInt(Phase::calculateTotalScore).sum();
    }

    static class Phase{
        private int score;
        private char bonus;
        private char option;
        private int optionNumber;

        public Phase() {
            optionNumber = 1;
            option = '\0';
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
            int bonusNumber = 1;
            switch(bonus){
                case 'S':
                    bonusNumber = 1;
                    break;
                case 'D':
                    bonusNumber = 2;
                    break;
                case 'T':
                    bonusNumber = 3;
                    break;
            }
            return this.optionNumber * (int)Math.pow(this.score,bonusNumber);
        }
    }
}