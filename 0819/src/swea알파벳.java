import java.util.Scanner;

public class swea알파벳 {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[] visited;
	static char[][] ch;
	static int ans, r, c;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		
		// 알파벳 수만큼의 배열
		// A를 빼줘 숫자로 바꿔서 해당 칸의 T,F여부 확인
		visited = new boolean[26];
		
		ch = new char[r][c];
		for(int i=0; i<r; i++) {
			String str = sc.next();
			for(int j=0; j<c; j++) {
				ch[i][j] = str.charAt(j);
			}
		}
		
		visited[ch[0][0]-'A'] = true;
		dfs(0, 0, 1);
		System.out.println(ans);
		
	}
	
	static void dfs(int x, int y, int cnt) {
		ans = Math.max(ans, cnt);
		
		// 4방 탐색 수행
		for(int i=0; i<4; i++) {
			int nr = x+dx[i];
			int nc = y+dy[i];
			
			if(nr >= 0 && nc >= 0 && nr < r && nc < c) {
				// 방문하지 않은 알파벳 칸이면
				if(!visited[ch[nr][nc]-'A']) {
					visited[ch[nr][nc]-'A'] = true;
					dfs(nr, nc, cnt+1);
					visited[ch[nr][nc]-'A'] = false;
				}
			}
		}
	}

}
