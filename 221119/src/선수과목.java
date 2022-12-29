import java.io.*;
import java.util.*;

public class 선수과목 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		int[] dp = new int[n+1];
		Arrays.fill(dp, 1);
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int prior = Integer.parseInt(st.nextToken());
			
			list[prior].add(prev);
		}
		
		sol(list, dp);
	}
	
	static void sol(ArrayList<Integer>[] list, int[] dp) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<dp.length; i++) {
			for(int next : list[i]) {
				dp[i] = Math.max(dp[i], dp[next]+1);
			}
		}
		
		for(int i=1; i<dp.length; i++) {
			sb.append(dp[i]+" ");
		}
		System.out.println(sb);
	}

}
