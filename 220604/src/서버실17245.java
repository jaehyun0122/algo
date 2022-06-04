import java.util.*;
import java.io.*;

public class ¼­¹ö½Ç17245 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		
		long total = 0;
		int max = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] != 0) total += arr[i][j];
				max = max < arr[i][j] ? arr[i][j] : max;
			}
		}
		
		sol(arr, total, max);
		
		
	}
	
	static void sol(int[][] arr, long total, int max) {
		int mid = 0;
		int min = 0;
		
		while(min+1 < max) {
			long cnt = 0;
			mid = (max+min)/2;
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					if(arr[i][j] > mid) {
						cnt += mid;
					}else cnt += arr[i][j];
				}
			}
//			System.out.println("max : "+max+" mid : "+mid+" min : "+min);
//			System.out.println("cnt : "+cnt);
			if(((double)cnt / total) >= 0.5) {
				max = mid;
			}else min = mid;
		}
		System.out.println(max);
	}
}
