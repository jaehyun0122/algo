import java.util.Scanner;

public class 백준9095 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] dp = new int[11];
		int T = sc.nextInt();
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int t=0; t<T; t++) {
			int n = sc.nextInt();
			
			for(int i=4; i<=n; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			System.out.println(dp[n]);
		}
	}

}
