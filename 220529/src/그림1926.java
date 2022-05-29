import java.util.*;
import java.io.*;

public class 그림1926 {

	static int[][] map;
	static int n,m;
	
	static class Dot{
		int x,y;
		
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		int max = 0;
		check = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1 && !check[i][j]) {
					max = Math.max(bfs(i,j), max);
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
	}

	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int cnt;
	static boolean[][] check;
	
	static int bfs(int x, int y) {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(x, y));
		check[x][y] = true;
		int size = 1;
		cnt++;
		while(!q.isEmpty()) {
			Dot cur = q.poll();
			for(int i=0; i<4; i++) {
				
				int nx = cur.x +dx[i];
				int ny = cur.y + dy[i];
				if(nx<0 || nx >= n || ny<0 || ny>=m) continue;
				
				if(map[nx][ny] == 1 && !check[nx][ny]) {
					size++;
					q.add(new Dot(nx, ny));
					check[nx][ny] = true;
				}
			}
		}
		return size;
	}
}
