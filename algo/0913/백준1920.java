package solution0913;

import java.util.Arrays;
import java.util.Scanner;

public class 백준1920 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int m = sc.nextInt();
		int[] mArr = new int[m];
		for(int i=0; i<m; i++) {
			mArr[i] = sc.nextInt();
		}
		
		// 이분 탐색을 위해 배열을 정렬한다.
		Arrays.sort(arr);
		// m만큼 반복을 돌면서 binarySearch함수를 실행.
		for(int i=0; i<m; i++) {
			int result = binarySearch(arr, mArr[i], 0, n-1);
			if(result == -1) System.out.println(0);
			else System.out.println(1);
		}
	}

	static int binarySearch(int[] arr, int target, int start, int end) {
		while(start <= end) {
			// 중간 값을 찾을 mid변수
			int mid = (start + end) / 2;
			// 중간값과 target이 같다면 중간값을 return
			if(arr[mid] == target) return mid;
			// 중간 값이 target보다 작으면 끝위치를 중간지점 -1
			if(arr[mid] > target) end = mid -1;
			// 중간 값이 target보다 크면 시작위치를 중간지점 +1
			else if(arr[mid] < target) start = mid + 1;
		}
		// 찾는 값이 없다면 -1을 return
		return -1;
	}
}
