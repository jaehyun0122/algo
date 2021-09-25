import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class swea프로세서연결하기 {
	
	static List<int[]> list;
	static int[][] arr;
	static int n;
	static int min, max, totalCnt;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			n = sc.nextInt();
			arr = new int[n][n];
			max = 0;
			min = Integer.MAX_VALUE;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			totalCnt = 0;
			list = new ArrayList<int[]>();
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					// 가장자리 코어 제외.
					if(i==0 || j==0 || i==n-1 || j==n-1) continue;
					// core일때
					if(arr[i][j] == 1) {
						list.add(new int[] {i, j});
						totalCnt++; // 가장자리가 아닌 코어 개수.
					}
				}
			}
			go(0, 0);
			System.out.println("#"+tc+" " + min);
		}
	}

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static void go(int idx, int cCnt ) {
		if(idx == totalCnt) {
			int res = getLength();
			// 선택된 코어 개수로 max 갱신
			if(max < cCnt) {
				max = cCnt;
				min = res;
			}else if(max == cCnt) { // 코어개수가 같으면 최소전선길이의 합.
				if(min > res) min = res;
			}
			return;
		}
			
		int[] cur = list.get(idx);
		int r = cur[0];
		int c = cur[1];
		// idx 코어 선택
		for(int d=0; d<4; d++) {
			if(isAvailable(r,c,d)) {
				// 전선 놓기
				setStatus(r,c,d,2);
				// 다음 코어로
				go(idx+1, cCnt+1);
				// 놓았던 전선 지우기
				setStatus(r,c,d,0);
			}
		}
		
		// idx 코어 미선택
		go(idx+1, cCnt);
	}

	private static void setStatus(int r, int c, int d, int s) {
		int nr = r, nc = c;
		while(true) {
			nr += dx[d];
			nc += dy[d];
			if(nr < 0 || nr >= n || nc < 0 || nc >= n) break;
			arr[nr][nc] = s;
		}
	}

	private static int getLength() {
		int res = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 2) res++;
			}
		}
		return res;
	}
	static boolean isAvailable(int r, int c, int d) {
		int nr = r, nc = c;
		while(true) {
			nr += dx[d];
			nc += dy[d];
			if(nr < 0 || nr >= n || nc < 0 || nc >= n) break;
			if(arr[nr][nc] >= 1) return false; // 코어가 있거나 전선이 있는 경우.
		}
		return true;
	}
}
