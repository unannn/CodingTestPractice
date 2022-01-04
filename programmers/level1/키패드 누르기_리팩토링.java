class Solution {

    enum Column{
        LEFT(0),
        MIDDLE(1),
        RIGHT(2);

        private final int index;

        Column(int index){
            this.index = index;
        }

        public int getColumnIndex() {
            return index;
        }

        public static Column of(int number){
            if(number % 3 == 1) return LEFT;
            else if(number % 3 == 2 || number == 0) return MIDDLE;
            else return RIGHT;
        }
    }

    public String solution(int[] numbers, String hand) {

        Hand leftHand = new Hand('*',Column.LEFT,'L');
        Hand rightHand = new Hand('#',Column.RIGHT,'R');

        char charNumber;
        Column columnOfNumber;
        for(int number : numbers){
            charNumber = Character.forDigit(number,10);
            columnOfNumber = Column.of(number);

            if(columnOfNumber == Column.LEFT) {
                leftHand.setLocation(charNumber, columnOfNumber);
            } else if (columnOfNumber == Column.RIGHT) {
                rightHand.setLocation(charNumber, columnOfNumber);
            } else {
                if (leftHand.getDistance(charNumber) > rightHand.getDistance(charNumber)){
                    rightHand.setLocation(charNumber, columnOfNumber);
                }
                else if (leftHand.getDistance(charNumber) < rightHand.getDistance(charNumber)){
                    leftHand.setLocation(charNumber, columnOfNumber);
                }
                else {
                    if (hand.equals("right")) {
                        rightHand.setLocation(charNumber, columnOfNumber);
                    }
                    else {
                        leftHand.setLocation(charNumber, columnOfNumber);
                    }
                }
            }
        }

        return Hand.getHandOrder().toString();
    }

    private static class Hand{

        private static final StringBuilder  handOrder = new StringBuilder();
        private static final char[][] Numbers = {{'1','4','7','*'}, {'2','5','8','0'}, {'3','6','9','#'}};
        private char position;
        private Column column;
        private final char hand;

        private Hand(char initPosition, Column column,char hand) {
            this.position = initPosition;
            this.column = column;
            this.hand = hand;
        }

        private static StringBuilder getHandOrder() {
            return handOrder;
        }

        public void setLocation(char location, Column vertical) {
            this.position = location;
            this.column = vertical;
            handOrder.append(this.hand);
        }

        private int getDistance(char number){
            int distance = Math.abs(getRowIndex(Column.MIDDLE,number) - getRowIndex(this.column,this.position));
            if(this.column != Column.MIDDLE) distance += 1;

            return distance;
        }

        private int getRowIndex(Column column, char position){
            int index = 0;
            for(char number :Numbers[column.getColumnIndex()]){
                if(number == position) break;
                index++;
            }

            if(index == Numbers[column.getColumnIndex()].length) {
                throw new RuntimeException("column 에 position 이 존재하지 않음");
            }

            return index;
        }
    }
}