import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
                .mapToInt(s -> {
                    int[] arr = Arrays.copyOfRange(array, s[0] - 1, s[1]);
                    Arrays.sort(arr);
                    return  arr[s[2] - 1];
                })
                .toArray();
    }
}