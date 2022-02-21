package solution0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준10816 {

	static StringTokenizer st;
	static int cnt;
	static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());
		int[] mArr = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<m; i++) {
			check = new boolean[500000];
			binarySearch(arr, mArr[i], 0, n-1);
			System.out.print(cnt+" ");
		}
	}

	static int binarySearch(int[] arr, int target, int start, int end) {
		cnt = 0;
		while(start <= end) {
			int mid = (start+end)/2;
			if(arr[mid] == target && !check[mid]) {
				cnt++;
				check[mid] = true;
				start += 2;
			}
			if(arr[mid] > target) end = mid -1;
			else if(arr[mid] < target) start = mid + 1;
		}
		return cnt;
	}
}
