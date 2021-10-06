import java.util.Scanner;


/*
1
5 1       
9 3 2 3 2 
6 3 1 7 5
3 4 8 9 9
2 3 7 7 7
7 6 5 5 8
 */

public class swea등산로조정 {

	static int[][] mountain;
	static int n,k;
	static boolean[][] check;
	static int ans;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			// 등산로 크기
			n = sc.nextInt();
			// 조정 횟수
			k = sc.nextInt();
			int max = -1;
			check = new boolean[n][n];
			mountain = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					mountain[i][j] = sc.nextInt();
					max = Math.max(max, mountain[i][j]);
				}
			}
			ans = 1;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(mountain[i][j] == max) dfs(i,j, false, 1, max);
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
		
	}

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static void dfs(int x, int y, boolean go, int cnt, int curH) {
		// 현재 위치 방문 체크
		check[x][y] = true;

		// 길이 최대값
	    ans = Math.max(ans, cnt);
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 범위 넘어가고 방문 되었으면 패스.
			if((nx >= n || ny >= n || nx < 0 || ny < 0)) continue;
			if(check[nx][ny]) continue;
			
			// 다음이 작으면 일단 간다.
			if(curH > mountain[nx][ny]) {
				dfs(nx, ny, go, cnt+1, mountain[nx][ny]);
			}
			// 깍을 수 있고
			else if(!go){
				// 깍은게 현재 높이보다 낮으면
				if(mountain[nx][ny]-k < curH) dfs(nx, ny, true, cnt+1, curH-1);
			}
		}
		// 다시 해봐야되니까
		check[x][y] = false;
	}
}
