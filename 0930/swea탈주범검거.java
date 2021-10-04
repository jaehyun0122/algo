import java.util.*;

public class swea탈주범검거 {

	static class path{
		int x, y,t;
		path(int x, int y, int t){
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	
	static int n,m;
	static int r,c;
	static int l;
	static int[][] arr;
	static boolean[][] check;
	static int[][] result;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int tc = 1; tc<= t; tc++) {
			// 하수도 크기
			n = sc.nextInt();
			m = sc.nextInt();
			// 맨홀 위치
			r = sc.nextInt();
			c = sc.nextInt();
			// 탈출 후 시간
			l = sc.nextInt();
			
			arr = new int[n][m];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println("#" + tc + " "+bfs());
		}
	}

	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] dir = {
			{0,0,0,0},
			{1,1,1,1},// 1
			{1,1,0,0},// 2
			{0,0,1,1},// 3
			{1,0,0,1},// 4
			{0,1,0,1},// 5
			{0,1,1,0},// 6
			{1,0,1,0}// 7
	};
	
	static int bfs() {
		Queue<path> q = new LinkedList<>();
		// 처음 탈출 시간 1
		q.add(new path(r, c, 1));
		check = new boolean[n][m];
		check[r][c] = true;
		result = new int[n][m];
		result[r][c] = 1;
		int cnt = 0;
		while(!q.isEmpty()) {
			path cur = q.poll();
			
			if(cur.t == l) continue;
			// 현재 파이프 모양을 가져온다.
			int pipe = arr[cur.x][cur.y];
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				boolean bln = false;
				
				// 범위를 벗어나면 패스
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if(check[nx][ny]) continue;
				
				// 이동가능 판별
				// 파이프 모양별 이동가능
				if(result[nx][ny] == 0 && dir[pipe][i] == 1) {
					// 다음 이동 방향과 모양이 맞으면
					int rpipe = arr[nx][ny];
					
					if(i == 0 && dir[rpipe][1] == 1) {
						bln = true;
					}
					else if(i == 1 && dir[rpipe][0] == 1) {
						bln = true;
					}
					else if(i == 2 && dir[rpipe][3] == 1) {
						bln = true;
					}
					else if(i == 3 && dir[rpipe][2] == 1) {
						bln = true;
					}
				}
				
				// 이동가능 할 시
				if(bln) {
					// 머문 시간 1을 더해주고 큐에 추가.
					q.add(new path(nx, ny, cur.t+1));
					check[nx][ny] = true;
					// 머문곳은 1로 바꾸고 
					result[nx][ny] = 1;
				}
			}
		}
		// 머문 곳이 있을 때 마다 카운트
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(result[i][j] == 1) cnt++;
				
			}
		}
		return cnt;
	}
	
}
