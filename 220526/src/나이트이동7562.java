import java.util.*;
import java.io.*;

public class 나이트이동7562 {

	static int start_x, start_y, end_x, end_y;
	static int[][] map;
	static boolean[][] check;
	static int n;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=0; t<TC; t++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			start_x = Integer.parseInt(st.nextToken());
			start_y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			end_x = Integer.parseInt(st.nextToken());
			end_y = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			check = new boolean[n][n];
			
			bfs(new Pos(start_x, start_y));
			System.out.println(map[end_x][end_y]);
		}
	}
	
    static int[] dx = {-2,-1,2,1,2,1,-2,-1};
    static int[] dy = {1,2,1,2,-1,-2,-1,-2};

    static void bfs(Pos pos) {
    	if(pos.x == end_x && pos.y == end_y) {
    		return;
    	}
    	check[pos.x][pos.y]= true;
    	
    	Queue<Pos> q = new LinkedList<>();
    	q.add(pos);
    	
    	while(!q.isEmpty()) {
    		Pos cur = q.poll();
    		
    		for(int i=0; i<8; i++) {
    			int nx = cur.x + dx[i];
    			int ny = cur.y + dy[i];
    			
    			if(nx<0 || nx>=n || ny<0 || ny >= n || check[nx][ny]) continue;
    			
    			q.add(new Pos(nx, ny));
    			check[nx][ny] = true;
    			map[nx][ny] = map[cur.x][cur.y]+1;
    		}
    	}
    	
    	
    	
    	
    }
    
    static class Pos{
    	int x,y;
    	
    	public Pos(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
}
