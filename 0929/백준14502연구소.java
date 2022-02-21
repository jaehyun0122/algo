import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준14502연구소 {

	static class virus{
		int x, y;
		virus(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int n,m,ans;
	static int[][] arr;
	static ArrayList<virus> list;
	static int[][] copy;
	static int[][] wall;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n][m];
		list = new ArrayList<>();
		ans = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = sc.nextInt();
				// virus리스트에 추가.
				if(arr[i][j] == 2) list.add(new virus(i,j));
			}
		}
		wall = copy(arr);
		makeWall(0);
		System.out.println(ans);
	}

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static void makeWall(int d) {
		if(d == 3) {
			goVirus();
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				// 벽이 없으면
				if(wall[i][j] == 0) {
					// 벽으로 바꾸고
					wall[i][j] = 1;
					// 벽을 만든다.
					makeWall(d+1);
					// 다른 경우를 해야하므로 다시 0으로 바꿔준다.
					wall[i][j] = 0;
				}
			}
		}
	}
	
	static void goVirus() {
		Queue<virus> q = new LinkedList<>();
		// virus를 pq에 넣어준다.
		for(int i=0; i<list.size(); i++) {
			q.add(new virus(list.get(i).x, list.get(i).y));
		}
		int[][] copy = copy(wall);
		
		while(!q.isEmpty()) {
			virus v = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				
				// 범위를 벗어나면 패스.
				if(nx < 0 || nx >=n || ny < 0 || ny >= m) continue;
				// 0인 곳을 virus로 만들어 준다.
				if(copy[nx][ny] == 0) {
					copy[nx][ny] = 2;
					// virus추가
					q.add(new virus(nx, ny));
				}
			}
		}
		// 안전구역을 카운트할 함수
		int result = cntArea(copy);
		ans = Math.max(ans, result);
	}
	
	static int cntArea(int[][] copy) {
		int cnt = 0;
		// 안전 구역을 만나면 카운트해준다.
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copy[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	static int[][] copy(int[][] arr) {

		int[][] copy = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}
}
