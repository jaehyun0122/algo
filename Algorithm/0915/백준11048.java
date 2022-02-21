import java.util.Scanner;

public class 백준11048 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n+1][m+1];
		int[][] dp = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				int a = dp[i-1][j];
				int b = dp[i-1][j-1];
				int c = dp[i][j-1];
				dp[i][j] = Math.max(Math.max(a, b), c) + arr[i][j];
			}
		}
		System.out.println(dp[n][m]);
		
	}

}
