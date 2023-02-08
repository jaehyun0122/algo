import java.util.*;
import java.io.*;

public class ¹Ì·ÎÅ½»ö {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		
		check = new boolean[n][m];
		
		bfs();
		System.out.println(map[n-1][m-1]);
		
	}
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static boolean[][] check;
	static int[][] map;
	
	static void bfs() {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			check[cur[0]][cur[1]] = true;
			
			for(int i=0; i<4; i++) {
				int nx = cur[0]+dx[i];
				int ny = cur[1]+dy[i];
				
				if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
				if(map[nx][ny] == 0) continue;
				if(check[nx][ny]) continue;
				
				q.add(new int[] {nx, ny});
				check[nx][ny] = true;
				map[nx][ny] = map[cur[0]][cur[1]]+1;
			}
		}
		
	
	}

}
