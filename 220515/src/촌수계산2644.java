import java.util.*;
import java.io.*;

public class 촌수계산2644 {

	static ArrayList<Integer>[] list;
	static int[] dist;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[p].add(c);
			list[c].add(p);
		}
		dist = new int[n+1];
		Arrays.fill(dist, -1);
		bfs(a, b);
		System.out.println(dist[b]);
		
	}

	static void bfs(int start, int end) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur== end) {
				return;
			}
			
			for(int i=0; i<list[cur].size(); i++) {
				int next = list[cur].get(i);
				if(dist[next] == -1) {
					q.add(next);
					dist[next] = dist[cur]+1;
				}
				
			}
		}
	}
	
}
