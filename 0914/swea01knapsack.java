import java.util.Scanner;

public class swea01knapsack {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int limit = sc.nextInt();
			
			int[] V = new int[n+1];
			int[] C = new int[n+1];
			for(int i=1; i<=n; i++) {
				V[i] = sc.nextInt();
				C[i] = sc.nextInt();
			}
			
			int[][] d = new int[n+1][limit+1];
			
			for(int i = 1; i<=n; i++) {
				for(int v = 1; v <= limit; v++) {
					if(V[i] <= v) {
						d[i][v] = Math.max(d[i-1][v], C[i]+d[i-1][v-V[i]]);
					}
					else d[i][v] = d[i-1][v];
				}
			}
			System.out.println("#"+T+ " " + d[n][limit]);
			
		}
	}

}
