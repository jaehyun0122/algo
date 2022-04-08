import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숫자카드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
//		int n = sc.nextInt();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[20000001];
		for(int i=0; i<N; i++) {
//			arr[sc.nextInt()+10000000]++;
			arr[Integer.parseInt(st.nextToken())+10000000]++;
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			sb.append(arr[Integer.parseInt(st.nextToken())+10000000]+" ");
		}
		System.out.println(sb);

//		int start = 0;
//		int end = m-1;
//		int mid = 0;
//		ans = new int[m];
//		
//		for(int i=0; i<m; i++) {
//			sol(arr2[i], arr, n, i);
//		}
//		//-10, -10, 2, 3, 3, 6, 7, 10, 10, 10
//		for(int a : ans) System.out.print(a+" ");
	}
//
//	static int[] ans;
//	static void sol(int a, int[] arr, int n, int cnt) {
//		int start = 0;
//		int end = n;
//		int mid = 0;
//		while(start<end) {
//			mid = (start+end)/2;
//			if(a == arr[mid]) {
//				for(int i=start; i<end; i++) {
//					if(a == arr[i]) ans[cnt]++; System.out.println("i"+i);
//				}
//				System.out.println("======");
//				break;
//			} else if(a > arr[mid]) {
//				start = mid+1;
//			} else if(a < arr[mid]) {
//				end = mid;
//			} 
//		}
//	}
}
