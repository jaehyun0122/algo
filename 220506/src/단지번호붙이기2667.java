import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 단지번호붙이기2667 {

	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		} // map 입력 끝
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1) {
					list.add(bfs(i, j, n, map));
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int result : list) System.out.println(result);
	}
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int bfs(int x, int y, int n, int[][] map) {
		int cnt = 0;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				
				if(nx>=n || ny>=n || nx<0 || ny<0) continue;
				if(map[nx][ny] == 1 ) {
					q.add(new Point(nx, ny));
					map[nx][ny] = 0;
					cnt++;
				}
			}
		}
		return cnt;
		
	}

}
