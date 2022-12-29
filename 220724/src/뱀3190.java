import java.util.*;
import java.io.*;


public class ¹ì3190 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[][] map = new int[n+1][n+1];
		list = new ArrayList<>();
		list.add(new Pos(1,1));
		dirMap = new HashMap<>();
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		int turn = Integer.parseInt(br.readLine());
		int dir = 0;
		int posX = 1;
		int posY = 1;
		int res = 0;
		
		for(int i=0; i<turn; i++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			dirMap.put(sec, str);
		}
		
		int nextX, nextY;
		while(true) {
			res++;
			nextX = posX+dx[dir];
			nextY = posY+dy[dir];
					
			if(!isRange(nextX, nextY, n)) {
				break;
			}
			
			if(map[nextX][nextY] == 1) {
				map[nextX][nextY] = 0;
				list.add(new Pos(nextX, nextY));
			} else {
				list.remove(0);
				list.add(new Pos(nextX, nextY));
			}

			posX = nextX;
			posY = nextY;
			
			if(dirMap.containsKey(res)) {
				if(dirMap.get(res).equals("D")) {
					dir++;
					if(dir == 4) dir = 0;
				} else {
					dir--;
					if(dir == -1) dir = 3;
				}
			}
		}
		
		System.out.println(res);
		
	}
	static class Pos{
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static ArrayList<Pos> list;
	static Map<Integer, String> dirMap;
	
	static boolean isRange(int x, int y, int n) {
		if(x > n || x < 1 || y > n || y < 1) return false;
		for(int i=0; i<list.size(); i++) {
			Pos p = list.get(i);
			if(p.x == x && p.y == y) return false;
		}
		return true;
	}
	
}
