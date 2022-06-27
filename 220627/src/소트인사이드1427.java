import java.util.*;
import java.io.*;

public class 소트인사이드1427 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num = br.readLine();
		int[] arr = new int[num.length()];
		int[] tmp = new int[num.length()];
		for(int i=0; i<num.length(); i++) {
			arr[i] = num.charAt(i)-'0';
		}
		
		mergeSort(arr, tmp, 0, arr.length-1);
		
		StringBuilder sb = new StringBuilder();
		
		for(int a : arr) {
			sb.append(a);
		}
		System.out.println(sb);
	}
	
	static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		int mid = (start+end)/2;
		if(start<end) {
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid+1, end);
			merge(arr, tmp, start, mid, end);
		}
	}
	
	static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		for(int i=0; i<arr.length; i++) {
			tmp[i] = arr[i];
		}
		
		int part1 = start;
		int part2 = mid+1;
		int idx = start;
		
		while(part1<=mid && part2<=end) {
			if(tmp[part1] > tmp[part2]) {
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
