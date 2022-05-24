import java.util.*;
import java.io.*;

public class 내리막길1520 {

	static int n,m;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		dp = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		
		System.out.println(dfs(1,1));
	}

	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	
	static int dfs(int a, int b) {
		if(a==n && b==m) return 1;
		
		if(dp[a][b] != -1) return dp[a][b];
		
		dp[a][b] = 0;
		for(int i=0; i<4; i++) {
			int nx = a+dx[i];
			int ny = b+dy[i];
			
			if(nx<1 || nx>n || ny<1 || ny>m) continue;
			
			if(map[a][b] > map[nx][ny]) {
				dp[a][b] += dfs(nx,ny);
			}
		}
		return dp[a][b];
	}
}
