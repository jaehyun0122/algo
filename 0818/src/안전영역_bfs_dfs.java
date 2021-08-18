import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 안전영역_bfs_dfs {

	static int[][] arr;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static int N,cnt,ans;
	static boolean[][] sel;
	
	static class Node {
		int r, c;
		
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		int h_max = 0;

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();
				h_max = Math.max(h_max, arr[i][j]);
			}
		}
		ans = 1;
		for(int h = 1; h <= h_max; h++) {
			sel = new boolean[N][N];
			cnt = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j] > h && !sel[i][j]) {
						cnt++;
						dfs(i,j,h);
					}
				}
			}
			
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
	
	static void dfs(int r, int c, int h) {
//		bfs
//		Queue<Node> q = new LinkedList<>();
//		q.add(new Node(r,c));
		sel[r][c] = true;
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
//			while(!q.isEmpty()) {
//				Node node = q.poll();
			if( nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if( arr[nr][nc] <= h) continue;
			if( sel[nr][nc]) continue;
			
//			q.add(new Node(nr,nc));
//			sel[nr][nc] = true;
//			bfs(nr,nc,h);
//		}
			dfs(nr, nc, h);
			
		}
	}
}
