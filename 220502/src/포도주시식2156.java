import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식2156 {

	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[n+1];
		dp[0] = -1;
		dp[1] = arr[1];
		if(n > 1) dp[2] = arr[1]+arr[2];
		if(n > 2) dp[3] = Math.max(Math.max(arr[3] + dp[1], dp[2]), arr[2]+arr[3]);
		for(int i=4; i<=n; i++) {
			dp[i] = Math.max(Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i], dp[i - 1]);
		}
		System.out.println(dp[n]);
	}

}
