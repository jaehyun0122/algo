import java.util.*;
import java.io.*;

public class 소수최소공배수21919 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		int max = -1;
		
		long ans = 1;
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = arr[i] > max ? arr[i] : max;
		}
		
		boolean[] check = new boolean[max+1];
		for(int i=0; i<n; i++) {
			if(sol2(arr[i]) && !check[arr[i]]) {
				ans *= arr[i];
				check[arr[i]] = true;
			}
		}
		
//		int[] arr1 = new int[max+1];
//		sol(arr1, max);	
//		for(int i=0; i<n; i++) {
//			for(int j=2; j<=max; j++) {
//				if(arr[i] == j && arr1[j] == 1 && !check[arr[i]]) {
//					ans *= arr[i];
//					check[arr[i]] = true;
//					break;
//				}
//			}
//		}
		System.out.println(ans == 1? -1 : ans);
	}

	static boolean sol2(int num) {
		for(int j=2; j<= Math.sqrt(num); j++) {
			if(num % j == 0) return false; 
		}
		return true;
	}
	
//	static void sol(int[] arr1, int max) {
//		for(int i=2; i<=max; i++) {
//			if(arr1[i] == 0) {
//				arr1[i] = 1;
//				for(int j=i+i; j<=max; j=j+i) {
//					if(j > max) break;
//					arr1[j] = 2;
//				}
//			}
//			
//		}
//	}
}
