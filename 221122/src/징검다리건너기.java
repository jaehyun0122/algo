import java.util.*;
import java.io.*;
public class 징검다리건너기 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] stone = new int[n+1][2];
		
		for(int i=1; i<n; i++) {
			st  = new StringTokenizer(br.readLine());
			int smallJump = Integer.parseInt(st.nextToken());
			int largerJump = Integer.parseInt(st.nextToken());
			
			stone[i][0] = smallJump;
			stone[i][1] = largerJump;
		}
		
		int k = Integer.parseInt(br.readLine());
		answer = Integer.MAX_VALUE;
		dfs(1,0,false, stone, k, n);
		
		System.out.println(answer);
		
	}
	static int answer;
	static void dfs(int idx, int energy, boolean bigJump, int[][] stone, int k, int n) {
		if(idx == n) {
			answer = energy > answer ? answer : energy;
			return;
		}
		if(idx > n) return;
		if(energy > answer) return;
		
		dfs(idx+1, energy+stone[idx][0], bigJump, stone, k, n);
		dfs(idx+2, energy+stone[idx][1], bigJump, stone, k, n);
		
		if(!bigJump) {
			dfs(idx+3, energy+k, true, stone, k, n);
		}
		
	}
	
	
}
