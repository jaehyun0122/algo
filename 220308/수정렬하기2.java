import java.util.PriorityQueue;
import java.util.Scanner;

public class 수정렬하기2 {
    private int SIZE;
    private int heapArr[];

    public 수정렬하기2(int arrSize){
        SIZE=0;
        heapArr= new int[arrSize+1];
    }

    public void insertHeap(int input)
    {
        int i = ++SIZE;
        //while(( i != 1) && ( input > heapArr[i/2])){ //max heap
        while(( i != 1) && ( input < heapArr[i/2])){ //min heap
            heapArr[i] = heapArr[i/2];
            i = i/2;
        }
        heapArr[i] = input;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] arr = new int[tc];

        for(int i=0; i<tc; i++){
            arr[i] = sc.nextInt();
        }
        수정렬하기2 h = new 수정렬하기2(arr.length);
        for(int i=0; i<arr.length; i++){
            h.insertHeap(arr[i]);
        }
        for(int result : h.heapArr){
            System.out.println(result);
        }
    }
}
