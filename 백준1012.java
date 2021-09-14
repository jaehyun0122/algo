import java.util.Scanner;

public class 백준1012 {

	static boolean[][] check;
	static int[][] land;
	static int m;
	static int n;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 가로
		for(int tc=0; tc<T; tc++) {
			m = sc.nextInt();
			// 세로
			n = sc.nextInt();
			// 배추의 위치 수
			int k = sc.nextInt();
		    land = new int[m][n];
			// 방문 체크할 배열
			check = new boolean[m][n];
			// 배추의 위치를 입력한다.
			for(int i=0; i<k; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				land[x][y] = 1;
			}
			int cnt = 0;
			// 배추밭을 돌면서 배추의 위치이면 dfs함수를 실행.
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(land[i][j] == 1) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static void dfs(int x, int y) {
		// 방문체크가 되지 않은 위치이면 방문체크를 해주고 배추를 0으로 바꿔준다.
		if(!check[x][y]) {
			check[x][y] = true;
			land[x][y] = 0;
			
			// 4방 탐색을 실행.
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// 이동 위치가 배추밭의 범위를 넘지 않으면 
				if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
					// 이동 위치에 배추가 있고 방문체크를 하지않았으면 
					if(land[nx][ny] == 1 && !check[nx][ny]) {
						dfs(nx, ny);
					}
				}
			}
		}
	}
}
