import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 징검다리건너기small {
	static int[] stone;
	static boolean[] dp;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		stone = new int[n+1];
		dp = new boolean[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			stone[i] = Integer.parseInt(st.nextToken());
		}
		
		
		String answer;
		dfs(1, n, k);
		answer = dp[n] ? "YES" : "NO";
		System.out.println(answer);
	}
	
	static void dfs(int idx, int n, int k) {
		if(idx == n) {
			dp[idx] = true;
			return;
		}
		
		if(dp[idx]) return;
		dp[idx] = true;
		
		for(int i=idx+1; i<=n; i++) {
			if(cal(idx, i) <= k) dfs(i, n, k);
		}
		
	}
	
	static int cal(int i, int j) {
		int sum = 0;
		
		sum = (j-i)*(1+Math.abs(stone[i]-stone[j]));
		
		return sum;
	}

}
