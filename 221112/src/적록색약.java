import java.util.*;
import java.io.*;
public class 적록색약 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[][] arr = new String[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = Character.toString(str.charAt(j));
			}
		}
		
		check = new boolean[n][n];
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!check[i][j]) {
					sol(arr, i, j, arr[i][j]);
					cnt++;
				}
			}
		}
		System.out.print(cnt+" ");
		cnt = 0;
		check = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!check[i][j]) {
					sol(arr, i, j);
					cnt++;
				}
			}
		}
		System.out.print(cnt);
		
	}
	
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static boolean[][] check;
	static void sol(String[][] arr, int x, int y, String tmpStr) {
		
		Queue<int[]> q = new LinkedList<>();
		check[x][y] = true;
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length) continue;
				if(!arr[nx][ny].equals(tmpStr)) continue;
				
				if(!check[nx][ny]) {
					q.add(new int[] {nx,ny});
					check[nx][ny] = true;
				}
				
			}
		}	
	}
	
	static void sol(String[][] arr, int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		check[x][y] = true;
		q.add(new int[] {x,y});
		String tmpStr = arr[x][y];
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length) continue;
				if(!arr[nx][ny].equals(tmpStr)) {
					if((tmpStr.equals("R") && arr[nx][ny].equals("G")) ||
							(tmpStr.equals("G") && arr[nx][ny].equals("R"))) {
						
							if(!check[nx][ny]) {
								q.add(new int[] {nx,ny});
								check[nx][ny] = true;
							}
							
					}else continue;
				}
				
				if(!check[nx][ny]) {
					q.add(new int[] {nx,ny});
					check[nx][ny] = true;
				}
				
			}
		}	
	}
	
	
}
