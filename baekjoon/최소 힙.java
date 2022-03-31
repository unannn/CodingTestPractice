import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static long[] minHeap;
    private static int size;
    private static StringBuilder sb = new StringBuilder(); 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        minHeap = new long[N+1];
        size = 0;
        for(int i = 0;i < N;i++){
            long X = Long.parseLong(br.readLine());
            if(X == 0){
                long min = delete();
                sb.append(min).append("\n");
            } else{
                insert(X);
            }
        }
        System.out.println(sb.toString());
    }

    private static long delete() {
        if(size == 0){
            return 0;
        }

        long min = minHeap[1];
        minHeap[1] = minHeap[size--];
        int pos = 1;
        while (pos <= size) {
            int left = pos * 2;
            int right = pos * 2 + 1;

            int smaller;

            if(left > size){
                break;
            }
            else if(right > size){
                smaller = left;
            }else{
                smaller = minHeap[left] > minHeap[right] ? right : left;
            }

            if(minHeap[smaller] < minHeap[pos]){
                swap(smaller,pos);
                pos = smaller;
            }else{
                break;
            }
        }
        minHeap[size + 1] = 0;
        return min;
    }

    private static void insert(long n) {
        size += 1;
        minHeap[size] = n;
        int child = size;
        int parent = child / 2;

        while(parent >= 1 && minHeap[parent] > minHeap[child]){
            swap(child, child / 2);
            child  = child / 2;
            parent = child / 2;
        }
    }

    private static void swap(int a, int b){
        long temp = minHeap[b];
        minHeap[b] = minHeap[a];
        minHeap[a] = temp;
    }
}