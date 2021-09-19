import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준2206벽부수고이동하기 {

	static int[][] arr;
	static int n, m;
	static boolean[][][] check;
	static int ans;
	
	static class Node{
		int x;
		int y;
		int cnt;
		boolean used;
		
		Node(int x, int y, int cnt, boolean used){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.used = used;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		check = new boolean[n][m][2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		ans = -1;
		check[0][0][0] = true;
		bfs(0, 0, 1, false);
		
		System.out.println(ans);
		
	}

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static void bfs(int x, int y, int cnt, boolean used) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y, cnt, used));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.x == n-1 && node.y == m-1) {
				ans = node.cnt;
				break;
			}
			
			for(int i=0; i<4; i++) {
				
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >=m) continue;
				
				
				if(arr[nx][ny] == 0 && !check[nx][ny][node.used?1:0]) {
					check[nx][ny][node.used?1:0] = true;
					q.add(new Node(nx, ny, node.cnt+1, node.used));
				}
				if(arr[nx][ny] == 1 && !node.used && !check[nx][ny][1]) {
					check[nx][ny][1] = true;
					q.add(new Node(nx, ny, node.cnt+1, true));
				}
			}
		}
	}
}
