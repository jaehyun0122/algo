import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class µ¿Àü2 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		int[] dp = new int[k+1];
		Arrays.fill(dp, 10001);
		dp[0] = 0;
		
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<n; i++) {
			for(int j=coin[i]; j<=k; j++) {
				dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
			}
		}
		int answer = dp[k] == 10001 ? -1 : dp[k];
		System.out.println(answer);
	}
	


	

}
