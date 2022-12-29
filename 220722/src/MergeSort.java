import java.util.*;

public class MergeSort {

	public static void main(String[] args) {

		int[] arr = {1,4,3,5,6,5,8};
		int[] tmp = new int[arr.length];
		
//		System.out.println(Arrays.toString(arr));
//		mergeSort(arr, 0, arr.length-1, tmp);
//		System.out.println(Arrays.toString(arr));
		
		int[][] map = new int[3][5];
		System.out.println(map.length);
		System.out.println(map[0].length);
	}
	
	
	private static void mergeSort(int[] arr, int start, int end, int[] tmp) {
		if(start < end) {
			int mid = (start+end)/2;
			mergeSort(arr, start, mid, tmp);
			mergeSort(arr, mid+1, end, tmp);
			merge(arr, start, mid, end, tmp);
		}
	}
	
	private static void merge(int[] arr, int start, int mid, int end, int[] tmp) {
		for(int i=start; i<=end; i++) {
			tmp[i] = arr[i];
		}
		int part1 = start;
		int part2 = mid+1;
		int idx = start;
		while(part1 <= mid && part2 <=end) {
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
