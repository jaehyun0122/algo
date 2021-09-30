import java.util.*;

public class swea보급로 {

	static class Node{
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int n;
	static int[][] load;
	static int[][] ans;
	static boolean[][] bln;
	static int min;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			load = new int[n][n];
			bln = new boolean[n][n];
			ans = new int[n][n];
			
			for(int i=0; i<n; i++) {
				String str = sc.next();
				for(int j=0; j<n; j++) {
					load[i][j] = str.charAt(j) - '0';
					ans[i][j] = Integer.MAX_VALUE;
				}
			}
			
			min = Integer.MAX_VALUE;
			ans[0][0] = 0;
			bfs(0, 0);
			System.out.println("#" + t + " " +min);
		}
		
	}

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static void bfs(int a, int b) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(a, b));
		bln[a][b] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(node.x == n-1 && node.y == n-1) {
				min = Math.min(min, ans[n-1][n-1]);
				return;
			}
			
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
				
				if(ans[nx][ny] > ans[node.x][node.y] + load[nx][ny] || !bln[nx][ny]) {
					ans[nx][ny] = ans[node.x][node.y] + load[nx][ny];
					q.add(new Node(nx, ny));
					bln[nx][ny] = true;
				}
				
			}
		}
	}
	
}
