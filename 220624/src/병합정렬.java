import java.util.Arrays;

public class 병합정렬 {

	static int[] sorted;
	static int num;
	
	public static void main(String[] args) {
		
//		int[] arr = {7,6,5,8,3,5,9,1};
		int[] arr = {5, 3, 6, 2};
		sorted = new int[arr.length];
		num = arr.length;
		
		System.out.println(Arrays.toString(arr));
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}

	private static void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length-1);
	}
	
	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if(start<end) {
			int mid = (start+end)/2;
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid+1, end);
			merge(arr, tmp, start, mid, end);
		}
	}
	
	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		System.out.println("call merge");
		for(int i = start; i <= end; i++) {
			tmp[i] = arr[i];
		}
		int part1 = start;
		int part2 = mid+1;
		int idx = start;
		while(part1 <= mid && part2 <= end) {
			if(tmp[part1] < tmp[part2]) {
				arr[idx] = tmp[part1];
				part1++;
			}else {
				arr[idx] = tmp[part2];
				part2++;
			}
			idx++;
		}
		for(int i=0; i<=mid-part1; i++) {
			arr[idx+i] = tmp[part1+i];
		}
	}
}
