import java.util.*;
import java.io.*;

public class 두수의합3273 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		
		System.out.println(sol(arr, x, n));
	}

	static int sol(int[] arr, int x, int n) {
		int cnt = 0;
		int start=0, end = n-1, sum = 0;
		Arrays.sort(arr);
		while(true) {
			if(start >= end) break;
			
			sum = arr[start]+arr[end];
			
			if(sum <= x) {
				if(sum == x ) cnt++;
				start++;
			}
			if(sum > x) end--;
		}
		
		
		return cnt;
	}
}
