import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프1890 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		long[][] dp = new long[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = 1;
		System.out.println(sol(0,0,arr,dp,n));
	}

	static long sol(int x, int y, int[][] arr, long[][] dp, int n) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int next = arr[i][j];
				if(next == 0) break;
				if(next+j<n) dp[i][j+next] += dp[i][j];
				if(next+i<n) dp[i+next][j] += dp[i][j];	
			}
		}
		
		return dp[n-1][n-1]; 
	}
}
