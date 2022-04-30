import java.util.Scanner;

public class 타일01 {

	public static void main(String[] args) {
		// n = 2
		// 00 11 2
		// n =3
		// 001 100 111 3 
		// n = 4
		// 0000 0011 1100 1111 1001 5
		// n = 5
		// 00001 00100 10000 11100 00111 11111 10011 11001 8
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 1) System.out.println(1);
//		else {
//			int[] dp = new int[n+1];
//			dp[1]=1;
//			dp[2]=2;
//			for(int i=3; i<=n; i++) {
//				dp[i] = (dp[i-2] + dp[i-1])%15746;
//			}
//			System.out.println(dp[n]);
//		}
		else {
			int[] dp = new int[n+2];
			System.out.println(sol(n+1, dp));
		}
	}
	static int sol(int n, int[] dp) {
		
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(dp[n] != 0) return dp[n];
		dp[n] = (sol(n-2, dp)+sol(n-1, dp))%15746;
		return dp[n];
	}
}
