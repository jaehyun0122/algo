import java.util.*;

public class 숫자카드210816 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int m = sc.nextInt();
		int[] arr2 = new int[m];
		for(int i=0; i<m; i++) {
			arr2[i] = sc.nextInt();
		}

		int start = 0;
		int end = m-1;
		int mid = 0;
		ans = new int[m];
		
		for(int i=0; i<m; i++) {
			sol(arr2[i], arr, n, i);
		}
		for(int a : ans) System.out.print(a+" ");
	}
	// 3 3 5 6 6 6 6 7 7 7 7 9
	// 3 5 6 7
	static int[] ans;
	static void sol(int a, int[] arr, int n, int cnt) {
		int start = 0;
		int end = n;
		int mid = 0;
		while(start<end) {
			mid = (start+end)/2;
			if(a == arr[mid]) {
				for(int i=start; i<end; i++) {
					if(a == arr[i]) ans[cnt]++;
				}
				break;
			} else if(a > arr[mid]) {
				start = mid+1;
			} else if(a < arr[mid]) {
				end = mid;
			} 
		}
	}
}
