import java.io.*;
import java.util.*;

public class 단지번호붙이기 {
	static int[][] map;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		check = new boolean[n][n];
		int total = 0;
		list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1 && !check[i][j]) {
					bfs(i,j,n);
					total++;
				}
			}
		}
		Collections.sort(list);
		System.out.println(total);
		for(int a : list) {
			System.out.println(a);
		}
		
		
	}
	static boolean[][] check;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static ArrayList<Integer> list;
	
	static void bfs(int x, int y, int n) {
		Queue<int[]> q = new LinkedList<>();
		check[x][y] = true;
		int cnt = 1;
		q.add(new int[]{x,y});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur[0]+dx[i];
				int ny = cur[1]+dy[i];
				
				if(nx >= n || ny>=n || nx<0 || ny<0) continue;
				if(check[nx][ny]) continue;
				if(map[nx][ny] == 0) continue;
				
				q.add(new int[] {nx,ny});
				check[nx][ny] = true;
				cnt++;
			}
		}
		list.add(cnt);
		
	}

}
