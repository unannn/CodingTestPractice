class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String s = Integer.toBinaryString(arr1[i] | arr2[i]);
            StringBuilder sb = new StringBuilder(s);

            while(sb.length() < n) {
                sb.insert(0, '0');
            }
            answer[i] = sb.toString()
                    .replaceAll("1","#")
                    .replaceAll("0"," ");
        }

        return answer;
    }
}