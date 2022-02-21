import java.util.PriorityQueue;
import java.util.Scanner;

public class 백준4485녹색옷입은애가젤다지 {

	static class Node implements Comparable<Node>{
		int x,y,w;
		Node(int x, int y, int w){
			this.x = x;
			this.y = y;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
		
	}
	
	static int[][] arr;
	static int[][] dist;
	static boolean[][] bln;
	static int INF = Integer.MAX_VALUE;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 1;

		while(true) {
			n = sc.nextInt();
			
			if(n == 0) break;
			
			arr = new int[n][n];
			dist = new int[n][n];
			bln = new boolean[n][n];
			// 배열의 정보를 입력
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
					dist[i][j] = INF;
				}
			}
			System.out.println("Problem "+ (cnt++) +": "+dijkstra());
		}
	}

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[0][0] = arr[0][0];
		pq.add(new Node(0,0,arr[0][0]));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >=n) continue;
				
				if(dist[nx][ny] > dist[cur.x][cur.y] + arr[nx][ny] ) {
					dist[nx][ny] = dist[cur.x][cur.y] + arr[nx][ny];
					pq.add(new Node(nx,ny,dist[nx][ny]));
				}
			}
		}
		return dist[n-1][n-1];
	}
}
