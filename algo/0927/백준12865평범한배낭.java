import java.util.Scanner;

public class 백준12865평범한배낭 {


	static int n,m;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 물건의 수
		n = sc.nextInt();
		// 무게 최대치
		m = sc.nextInt();
		int[] k = new int[n+1];
		int[] v = new int[n+1];
		
		for(int i=0; i<n; i++) {
			k[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		int[] d = new int[m+1];
		
		for(int i=1; i<=n; i++) {
			for(int j = m; j >= k[i]; j--) {
				d[j] = Math.max(d[j], v[i]+d[j-k[i]]);
			}
		}
		System.out.println(d[m]);
	}

}
