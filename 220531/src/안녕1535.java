import java.util.*;
import java.io.*;

public class 안녕1535 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] hp = new int[n+1];
		int[] point = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			hp[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			point[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[100];
		
		for(int i=1; i<=n; i++) {
			for(int j=99; j>=hp[i]; j--) {
				dp[j] = Math.max(point[i] + dp[j-hp[i]], dp[j]);
			}
		}
		System.out.println(dp[99]);
	}

}
