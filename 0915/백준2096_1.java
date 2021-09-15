import java.util.Scanner;

public class 백준2096_1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] down = new int[n][3];
		int[][] dp = new int[n][3];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				down[i][j] = sc.nextInt();
			}
		}
		dp[0][0] = down[0][0];
		dp[0][1] = down[0][1];
		dp[0][2] = down[0][2];
		
		for(int i=1; i<n; i++) {
			// 첫번째 숫자를 골랐을 때 1 또는 2를 고를 수 있다.
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + down[i][0];
			// 두번째 숫자를 골랐을 때 3숫자 모두 고를 수 있다.
			dp[i][1] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]) + down[i][1];
			// 세번째 숫자를 골랐을 때 2 또는 3을 고를 수 있다.
			dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) + down[i][2];
		}
		int maxAns = Math.max(Math.max(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
		
		for(int i=1; i<n; i++) {
			// 첫번째 숫자를 골랐을 때 1 또는 2를 고를 수 있다.
			dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + down[i][0];
			// 두번째 숫자를 골랐을 때 3숫자 모두 고를 수 있다.
			dp[i][1] = Math.min(Math.min(dp[i-1][0], dp[i-1][1]), dp[i-1][2]) + down[i][1];
			// 세번째 숫자를 골랐을 때 2 또는 3을 고를 수 있다.
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + down[i][2];
		}
		int minAns = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
		System.out.println(maxAns + " " + minAns);
	}
}
