import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기1 {
	
	// 우 우하 하
	static int[] dr = {0,1,1}; 
	static int[] dc = {1,1,0};
	static int cnt, N;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// (1,1) (1,2)에 처음 파이프가 위치함.
		// 1부터 시작. N+1개의 배열생성
		arr = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 처음 파이프 끝이 (1,2)에.
		// (1,2) 부터 시작.
		dfs(1,2,0);
		System.out.println(cnt);
	}
	
	static void dfs(int r, int c, int direction) {
		// 끝에 도달하면 카운트 세줌
		// 함수 종료.
		if(r == N && c == N) {
			cnt++;
			return;
		}
		
		// 탐색시작 0 : 우 , 1 : 우하, 2: 하
		for(int d=0; d<3; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			// 방향이 우 인데 하로 가는 경우 패스
			if( direction == 0 && d == 2) continue;
			// 방향이 하 인데 우로 가는 경우 패스
			if( direction == 2 && d == 0) continue;
			// 우 우하 하에 1이 있으면 패스
			if( d == 1 && r+1 <= N && c+1 <= N) {
				if(arr[r][c+1] == 1 || arr[r+1][c] == 1 || arr[r+1][c+1] == 1) continue;
			}

			// 위의 조건으로 다른 방향이거나 벽이 있는 경우 제외됨.
			// 다음 방향에 벽이 없으면 재귀 ㄱ.
			if( nr > 0 && nc > 0 && nr <= N && nc <= N) {
				if(arr[nr][nc] == 0) dfs(nr,nc,d);
			}
			
		}
	}
	
}
