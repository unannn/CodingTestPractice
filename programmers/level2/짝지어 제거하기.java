import java.util.Stack;

class Solution
{
    public int solution(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!stack.empty()){
                if(stack.peek() == charArray[i]) stack.pop();
                else stack.push(charArray[i]);
            }
            else {
                stack.push(charArray[i]);
            }
        }

        if(stack.size() == 0)return 1;
        return 0;
    }
}