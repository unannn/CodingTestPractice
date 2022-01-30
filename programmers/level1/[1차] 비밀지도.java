import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        StringBuilder sb;
        ArrayList<String> Strings1 = new ArrayList<>();
        ArrayList<String> Strings2 = new ArrayList<>();
        setBinaryStrings(Strings1, arr1, n);
        setBinaryStrings(Strings2, arr2, n);

        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if(Strings1.get(i).charAt(j) == '1' || Strings2.get(i).charAt(j) == '1'){
                    sb.append("#");
                }
                else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    private void setBinaryStrings(ArrayList<String> Strings, int[] arr,int n) {
        StringBuilder sb;
        for (int i : arr) {
            sb = new StringBuilder();
            sb.append(String.format(Integer.toBinaryString(i)));
            while(sb.length() < n){
                sb.insert(0, "0");
            }
            Strings.add(sb.toString());
        }
    }
}