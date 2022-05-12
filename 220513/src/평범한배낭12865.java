import java.util.*;
import java.io.*;

public class 평범한배낭12865 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] w = new int[n+1];
		int[] v = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[m+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=m; j>=w[i]; j--) {
				dp[j] = Math.max(v[i]+dp[j-w[i]], dp[j]);
			}
		}
		
		System.out.println(dp[m]);
	}

}
