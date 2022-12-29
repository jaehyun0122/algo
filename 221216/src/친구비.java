import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ä£±¸ºñ {

	static int[] parent;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}
		int[] cost = new int[n+1];
		for(int i=1; i<=n; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		int[] min = new int[n+1];
		Arrays.fill(min, Integer.MAX_VALUE);
		
		
		
	}

	static int find(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot > yRoot) parent[yRoot] = xRoot;
		else parent[xRoot] = yRoot;
	}
	
}
