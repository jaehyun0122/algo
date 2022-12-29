import java.io.*;
import java.util.*;
public class �����ձ��ϱ�5 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		 int[][] dp = new int[n+1][n+1];
	      for(int i=1;i<=n;i++) {
	    	  for(int j=1;j<=n;j++) {
	    		  dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+arr[i][j];
	    	  }
	      }
		
		
		for(int tc=0; tc<m; tc++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			long answer = getSum(x1, y1, x2, y2, dp);
			
			System.out.println(answer);
			
//			for(int[] a : dp) {
//				for(int b : a) System.out.print(b+" ");
//				System.out.println();
//			}
		}
		
		
	}
	
	static private int getSum(int x1, int y1, int x2, int y2, int[][] dp) {
		int sum = 0;
		
		sum = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
		
		return sum;
	}

}
