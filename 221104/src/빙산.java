import java.io.*;
import java.util.*;

public class 빙산 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		mountain = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				mountain[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 0;
		int zero = 0;
		int[][] subMap = new int[n][m];
		
		while(true) {
			// 분리 되면 break;
			int cnt = 0;
			check = new boolean[n][m];
			for(int i=0; i<mountain.length; i++) {
				for(int j=0; j<mountain[i].length; j++) {
					if(mountain[i][j] != 0 && !check[i][j]) {
							bfs(i, j);
							cnt++;
					}
				}
			}
			if(cnt >= 2) {
				System.out.println(year);
				break;
			}
			// 다 0이면 break;
			if(cnt == 0) {
				System.out.println(0);
				break;
			}
			
			// 녹이기
			check = new boolean[n][m];
			for(int i=0; i<mountain.length; i++) {
				for(int j=0; j<mountain[i].length; j++) {
					if(mountain[i][j] != 0) {
						mountain[i][j] = melt(i,j);	
					}
				}
			}
			
			year++;
			
		}
		
	}
	
	static int[][] mountain;
	static boolean[][] check;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int melt(int x, int y) {
		check[x][y] = true;
		int cnt = 0;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx < 0 || ny < 0 || nx >= mountain.length || ny >= mountain[0].length) continue;
			if(mountain[nx][ny] == 0 && !check[nx][ny]) {
				cnt++;
			}
		}
		return mountain[x][y]-cnt <= 0 ? 0 : mountain[x][y]-cnt;  
	}
	
	
	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));

		check[x][y] = true;
		
		while(!q.isEmpty()) {
			
			Point cur = q.poll();
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(check[nx][ny]) continue;
				if(nx < 0 || ny < 0 || nx >= mountain.length || ny >= mountain[0].length) continue;
				if(mountain[nx][ny] != 0) {
					check[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
		
	}
	
	
	static class Point{
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
