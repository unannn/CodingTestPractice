class Solution {

    enum Vertical{
        LEFT,
        MIDDLE,
        RIGHT
    }

    public String solution(int[] numbers, String hand) {

        StringBuilder answer = new StringBuilder("");
        Hand leftHand = new Hand('*',Vertical.LEFT);
        Hand rightHand = new Hand('#',Vertical.RIGHT);

        for(int number : numbers){
            char charNumber = Character.forDigit(number,10);

            if(getVertical(number) == Vertical.LEFT){
                leftHand.setLocation(charNumber, Vertical.LEFT);
                answer.append("L");
            }
            else if(getVertical(number) == Vertical.RIGHT){
                rightHand.setLocation(charNumber,Vertical.RIGHT);
                answer.append("R");
            }
            else{

                if(leftHand.getDistance(number) > rightHand.getDistance(number)){
                    rightHand.setLocation(charNumber,Vertical.MIDDLE);
                    answer.append("R");
                }
                else if(leftHand.getDistance(number) < rightHand.getDistance(number)){
                    leftHand.setLocation(charNumber,Vertical.MIDDLE);
                    answer.append("L");
                }
                else{
                    if(hand.equals("right")){
                        rightHand.setLocation(charNumber,Vertical.MIDDLE);
                        answer.append("R");
                    }
                    else{
                        leftHand.setLocation(charNumber,Vertical.MIDDLE);
                        answer.append("L");
                    }
                }
            }
        }

        return answer.toString();
    }

    private Vertical getVertical(int number){
        if(number % 3 == 1) return Vertical.LEFT;
        else if(number % 3 == 2 || number == 0) return Vertical.MIDDLE;
        else{
            return Vertical.RIGHT;
        }
    }

    private static class Hand{

        private static final char[][] Numbers = {{'1','4','7','*'}, {'2','5','8','0'}, {'3','6','9','#'}};
        private char location;
        private int verticalIndex;

        private Hand(char location, Vertical vertical) {
            this.location = location;
            this.verticalIndex = vertical.ordinal();
        }

        public void setLocation(char location, Vertical vertical) {
            this.location = location;
            this.verticalIndex = vertical.ordinal();

        }

        private int getDistance(int number){

            char numberChar = Character.forDigit(number,10);
            int index = 0;
            int distance = 0;

            for(char middleNumber : Numbers[1]){
                if(numberChar == middleNumber) break;
                index++;
            }

            distance = Math.abs(index - getRowIndex(location));

            if(verticalIndex != 1) distance += 1;

            return distance;
        }

        private int getRowIndex(char location){
            int index = 0;
            for(char number :Numbers[verticalIndex]){
                if(number == location) return index;
                index++;
            }

            return -1;
        }
    }
}