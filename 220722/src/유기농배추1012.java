import java.util.*;
import java.io.*;

public class ¿Ø±‚≥ÛπË√ﬂ1012 {

	static class Point{
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			map = new int[m][n];
			check = new boolean[m][n];
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
			int cnt = 0;
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == 1 && !check[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		} // end tc
		
		
	}
	static int[] dx = {0, 1, 0 , -1};
	static int[] dy = {-1, 0, 1, 0};
	static boolean[][] check;
	static int[][] map;
	
	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		check[x][y] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx >= map.length || nx < 0 || ny >= map[0].length || ny < 0) continue;
				
				if(map[nx][ny] == 1 && !check[nx][ny]) {
					q.add(new Point(nx, ny));
					check[nx][ny] = true;
				}
			}
		}
		
		
		
	}
	
}
