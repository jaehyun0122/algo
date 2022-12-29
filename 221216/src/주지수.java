import java.util.*;
import java.io.*;
public class ÁÖÁö¼ö {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken())
						+map[i-1][j]+map[i][j-1]-map[i-1][j-1];
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(sum(st, map)+"\n");
		}
		
		System.out.println(sb);
	}

	static int sum(StringTokenizer st, int[][] map) {
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		int sum = 0;
		sum = map[x2][y2] - map[x2][y1-1] - map[x1-1][y2] + map[x1-1][y1-1];
		return sum;
		
	}
	
}
