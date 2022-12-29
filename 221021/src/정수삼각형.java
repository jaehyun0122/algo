import java.io.*;
import java.util.*;

public class Á¤¼ö»ï°¢Çü {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<i+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i==n-1) {
					dp[i][j] = arr[i][j];
				}
			}
		}
		
		for(int i=n-2; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				dp[i][j] = 
						arr[i][j]+Math.max(dp[i+1][j], dp[i+1][j+1]);
			}
		}
		
		System.out.println(dp[0][0]);
		
	}

}
