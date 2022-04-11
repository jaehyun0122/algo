import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M15649 {

	static int n, m;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		visited = new boolean[n+1];
		sol(0);
	}
	
	static void sol(int cnt) {
		if(cnt == m) {
			for(int i=0; i<m; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(visited[i]) continue;
			arr[cnt] = i;
			visited[i] = true;
			sol(cnt+1);
			visited[i] = false;
		}
		
	}

}
