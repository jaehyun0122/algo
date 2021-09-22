import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준7576토마토 {

	static class Node{
		int x,y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static Queue<Node> q;
	static int m,n;
	static int[][] tomato;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// m : 세로 n : 가로
		m = sc.nextInt();
		n = sc.nextInt();
		
		tomato = new int[n][m];
		q = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				tomato[i][j] = sc.nextInt();
				// 익은 토마토가 있으면 큐에 추가.
				if(tomato[i][j] == 1) q.add(new Node(i,j));
			}
		}
		System.out.println(bfs());
	}

	// 델타 배열.
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int bfs() {
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				// 배열 범위에 벗어나면 패스.
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				// 안익은 토마토가 있으면
				if(tomato[nx][ny] == 0) {
					// 익은토마토에 추가해주고
					// 날짜를 얻기 위해 1을 더해준다.
					q.add(new Node(nx, ny));
					tomato[nx][ny] = tomato[node.x][node.y]+1;
				}
			}
		}
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				// 안익은 토마토가 있으면 -1을 리턴.
				if(tomato[i][j] == 0) return -1;
				ans = Math.max(ans, tomato[i][j]);
			}
		}
		return ans-1;
	}
}
