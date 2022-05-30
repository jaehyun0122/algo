import java.util.*;
import java.io.*;

public class 토마토7569 {

	static class Tomato{
		int x,y,z;
		
		public Tomato(int z, int x,int y) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static int n,m,h;
	static int[][][] box;
	static Queue<Tomato> q;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		box = new int[h][m][n];
		q = new LinkedList<>();
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<m; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<n; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] == 1) q.add(new Tomato(i,j,k));
				}
			}
		}
		
		System.out.println(bfs());
		
	}

	static int[] dx = {0 , 0 , 0, 1, 0, -1};
	static int[] dy = {0, 0, -1, 0, 1, 0};
	static int[] dz = {1, -1, 0, 0, 0, 0};
	
	static int bfs() {
		while(!q.isEmpty()) {
			Tomato cur = q.poll();
			
			for(int i=0; i<6; i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				int nz = cur.z+dz[i];
				
				if(nx<0 || nx>=m || ny<0 || ny>=n || nz<0 || nz>=h) continue;
				
				if(box[nz][nx][ny] == 0) {
					q.add(new Tomato(nz,nx,ny));
					box[nz][nx][ny] = box[cur.z][cur.x][cur.y] + 1; 
				}
			}
		}
		
		int ans = calDay();
		return ans;
		
	}
	
	static int calDay() {
		int day = Integer.MIN_VALUE;
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<m; j++) {
				for(int k=0; k<n; k++) {
					if(box[i][j][k] == 0) return -1;
					
					day = Math.max(day, box[i][j][k]);
				}
			}
		}
		
		if(day == 0) return 0;
	
		else return day-1;
	}
}
