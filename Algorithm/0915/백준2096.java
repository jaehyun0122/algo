import java.util.Scanner;

public class 백준2096 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] down = new int[n][3];
		int[][] dpMax = new int[n+1][3];
		int[][] dpMin = new int[n+1][3];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				down[i][j] = sc.nextInt();
			}
		}
		dpMax[0][0] = down[0][0];
		dpMax[0][1] = down[0][1];
		dpMax[0][2] = down[0][2];

		dpMin[0][0] = down[0][0];
		dpMin[0][1] = down[0][1];
		dpMin[0][2] = down[0][2];
		int maxAns = 0;
		int minAns = Integer.MAX_VALUE;
		for(int i=1; i<n; i++) {
			// 첫번째 숫자를 골랐을 때 0 또는 1를 고를 수 있다.
			dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + down[i][0];
			// 두번째 숫자를 골랐을 때 3숫자 모두 고를 수 있다.
			dpMax[i][1] = Math.max(Math.max(dpMax[i-1][0], dpMax[i-1][1]), dpMax[i-1][2]) + down[i][1];
			// 세번째 숫자를 골랐을 때 2 또는 3을 고를 수 있다.
			dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + down[i][2];
			
			// 첫번째 숫자를 골랐을 때 0 또는 1를 고를 수 있다.
			dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + down[i][0];
			// 두번째 숫자를 골랐을 때 3숫자 모두 고를 수 있다.
			dpMin[i][1] = Math.min(Math.min(dpMin[i-1][0], dpMin[i-1][1]), dpMin[i-1][2]) + down[i][1];
			// 세번째 숫자를 골랐을 때 2 또는 3을 고를 수 있다.
			dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + down[i][2];
		}
		maxAns = Math.max(Math.max(dpMax[n-1][0], dpMax[n-1][1]), dpMax[n-1][2]);
		minAns = Math.min(dpMin[n-1][0], Math.min(dpMin[n-1][1], dpMin[n-1][2]));
		
//		for(int i=1; i<n; i++) {
//			// 첫번째 숫자를 골랐을 때 0 또는 1를 고를 수 있다.
//			dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + down[i][0];
//			// 두번째 숫자를 골랐을 때 3숫자 모두 고를 수 있다.
//			dp[i][1] = Math.min(Math.min(dp[i-1][0], dp[i-1][1]), dp[i-1][2]) + down[i][1];
//			// 세번째 숫자를 골랐을 때 2 또는 3을 고를 수 있다.
//			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + down[i][2];
//		}
		System.out.println(maxAns + " " + minAns);
	}
}
