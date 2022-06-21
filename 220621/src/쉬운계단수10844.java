import java.util.*;
import java.io.*;

public class 쉬운계단수10844 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int mod = 1000000000;
		
		int[][] dp = new int[num+1][10];
		
		for(int i=1; i<=9; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= num; i++) {
			for (int j = 0; j <= 9; j++) {
	            if (j == 0)
	                dp[i][j] = (dp[i - 1][j + 1]) % mod;
	            else if (j == 9) dp[i][j] = (dp[i - 1][j - 1]) % mod;
	            else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }
		
		long sum = 0;
		for(int i=0; i<=9; i++) {
			sum += dp[num][i];
		}
		System.out.println(sum%mod);
	}

}
