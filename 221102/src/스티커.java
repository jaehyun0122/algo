import java.util.*;
import java.io.*;
public class ½ºÆ¼Ä¿ {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<TC; tc++) {
			int len = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][len+1];
			int[][] dp = new int[2][len+1];
			
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=len; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			
			
			for(int i=2; i<=len; i++) {
				dp[0][i] = Math.max(dp[1][i-2], dp[1][i-1])+arr[0][i];
				dp[1][i] = Math.max(dp[0][i-2], dp[0][i-1])+arr[1][i];
			}
			
//			for(int i=0; i<2; i++) {
//				for(int j=0; j<=len; j++) {
//					System.out.print(dp[i][j]+" ");
//				}
//				System.out.println();
//			}
			System.out.println(Math.max(dp[0][len], dp[1][len]));			
			
		}
	}

}
