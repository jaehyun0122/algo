public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = {50,80,70,10,60,20,40,30};

        int temp = 0;
        int idx = 0;

        for(int i=1; i<arr.length; i++){
            temp = arr[i];
            idx=i;
            while((idx>0) && arr[idx-1] > temp){
                arr[idx] = arr[idx-1];
                idx--;
            }
            arr[idx] = temp;
        }
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
