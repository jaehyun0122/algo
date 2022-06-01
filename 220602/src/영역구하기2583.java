import java.util.*;
import java.io.*;

public class 영역구하기2583 {

	static int[][] map;
	static int n,m;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		check = new boolean[m][n];
		list = new ArrayList<>();
		int num = 0;
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());
			
			draw(start_x, start_y, end_x, end_y);
		}
		
		for(int i=0;i<m; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 0 && !check[i][j]) {
					num++;
					calc(i,j);
				}
			}
		}
		
		System.out.println(num);
		Collections.sort(list);
		for(int a : list) System.out.print(a+" ");
	}

	static void draw(int s_x, int s_y, int e_x, int e_y) {
		
		for(int i=s_x; i<e_x; i++) {
			for(int j=s_y; j<e_y; j++) {
				if(map[i][j] == 0) map[i][j] = 1;
			}
		}
	}
	
	static boolean[][] check;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static ArrayList<Integer> list;
	
	static class Dot{
		int x,y;
		
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void calc(int x, int y) {
		Queue<Dot> q = new LinkedList<>();
		check[x][y] = true;
		q.add(new Dot(x,y));
		
		int size = 1;
		
		while(!q.isEmpty()) {
			
			Dot cur = q.poll();
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
				if(map[nx][ny] != 0) continue;
				
				if(!check[nx][ny]) {
					q.add(new Dot(nx, ny));
					check[nx][ny] = true;
					size++;
				}
			}
		}
		list.add(size);
	}
}
