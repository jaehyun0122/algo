import java.util.*;

public class 봉우리 {

	static int[][] arr;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		arr = new int[n][n];
		cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(sol(i,j,n)) cnt++;
			}
		}
		System.out.println(cnt);
	}

	static int[] nx = {0,1,0,-1};
	static int[] ny = {-1,0,1,0};
	static int cnt;
	static boolean sol(int n , int m, int max) {
		for(int i=0; i<4; i++) {
			int dx = n + nx[i];
			int dy = m + ny[i];
			
			if(dx<0 || dy<0 || dx>=max || dy>=max) continue;
			if(arr[n][m] <= arr[dx][dy]) return false;
		}
		return true;
	}
}
