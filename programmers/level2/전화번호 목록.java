import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            String s1 = phone_book[i];
            String s2 = phone_book[i+1];
            if(s1.length() > s2.length()){
                s1 = phone_book[i+1];
                s2 = phone_book[i];
            }
            if(s2.substring(0,s1.length()).equals(s1)) return false;
        }

        Arrays.sort(phone_book,(o1, o2) -> {
            if(o1.length() != o2.length()){
                return o1.length() - o2.length();
            } else{
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i+1].substring(0,phone_book[i].length()).equals(phone_book[i])) return false;
        }
        return true;
    }
}