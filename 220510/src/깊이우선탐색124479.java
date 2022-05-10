import java.util.*;
import java.io.*;

public class 깊이우선탐색124479 {

	static int[][] adjMatrix;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[n+1][n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1;
		}
		check = new boolean[n+1];
//		dfs(start, visited);
	}

	static boolean[] check;
	
    static void dfs(int cur, boolean[] visited){
        visited[cur] = true;
        System.out.print(cur+" ");
//        for(int i=1; i<=n; i++){
//            if(!visited[i] && adjMatrix[cur][i] == 1){
//                dfs(i, visited);
//            }
//        }
    }

}
