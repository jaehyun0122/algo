import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기1929 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
//		for(int i=n; i<=m; i++) {
//			if(isPrime(i)) System.out.println(i);
//		}
		int[] arr = new int[m+1];
		sol(arr, n, m);
//		for(int a : arr) System.out.println(a);
	}
	static void sol(int[] arr, int n, int m) {
		for(int i=2; i<=m; i++) {
			if(arr[i] == 0) {
				arr[i] = 1;
				if(i >= n) System.out.println(i);
				for(int j=i;j<=m;j=j+i) {
					if(arr[j] != 0) continue;
					arr[j] = 1;
				}
			}
		}
	}
	

	static boolean isPrime(int a) {
		
		for(int i=2; i<=Math.sqrt(a); i++) {
			if((a%i)==0) {
				return false;
			}
		}
		return true;
	}
}
