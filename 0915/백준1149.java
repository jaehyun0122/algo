import java.util.Scanner;

public class 백준1149 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] paint = new int[n][3];
		int[][] dp = new int[n][3];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				paint[i][j] = sc.nextInt();
			}
		}
		
		dp[0][0] = paint[0][0];
		dp[0][1] = paint[0][1];
		dp[0][2] = paint[0][2];
		
		for(int i=1; i< n; i++) {
			// red를 골랐을 때
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + paint[i][0];
			// green을 골랐을 때
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + paint[i][1];
			// blue를 골랐을 때
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + paint[i][2];
		}
		int ans = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
		System.out.println(ans);
	}

}
