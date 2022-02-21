import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준17086 {

	static int[][] arr;
	static boolean[][] check;
	static int n;
	static int m;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n][m];
		// 수족관의 데이터를 입력
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int result = 0;
		int ans = 0;
		// 수족관에서 1을 만나면 dfs실행
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 1) continue;
			result = dfs(i,j);
			ans = ans > result ? ans : result;
			}
		}
		System.out.println(ans);
	}

	// 8방 탐색 델타
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	static int dfs(int x, int y) {
		check = new boolean[n][m];
		Queue<int[]> q = new LinkedList<int[]>();
		// 큐에 상어가 있는 위치와 거리 계산을 위한 d를 add.
		q.add(new int[] {x,y,0});
		// 방문 체크.
		check[x][y] = true;
	
		while(!q.isEmpty()) {
			int[] a = q.poll();
			for(int i=0; i<8; i++) {
				int nx = a[0] + dx[i];
				int ny = a[1] + dy[i];
				int d = a[2];
				// 수족관 범위 넘어가면 패스
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				// 해당 위치가 방문 체크되어있으면 패스
				if(check[nx][ny]) continue;
				// 다른 상어의 위치를 만나면 거리를 더해주고 리턴.
				if(arr[nx][ny] == 1) {
					return d+1;
				}
				// 1을 못만날시 해당 위치 방문 체크해주고 큐에 현재 위치와 거리를 1더해준다.
				check[nx][ny] = true;
				q.add(new int[] {nx, ny, d+1});
			}
		}
		// 위 조건에 해당하지 않으면 0을 리턴.
		return 0;
	}
}
