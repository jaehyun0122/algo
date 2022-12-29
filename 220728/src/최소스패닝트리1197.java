import java.io.*;
import java.util.*;

public class 최소스패닝트리1197 {

	static class Graph implements Comparable<Graph>{
		int x, y, c;
		
		public Graph(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
		
		@Override
		public int compareTo(Graph o) {
			return this.c - o.c;
		}
	}
	
	static ArrayList<Graph> list;
	static int[] parents;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parents = new int[n+1];
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
		list = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.add(new Graph(x,y,c));
		}
		
		Collections.sort(list);
		int sum = 0;
		
		for(int i=0; i<list.size(); i++) {
			Graph g = list.get(i);
			
			if(find(g.x) != find(g.y)) {
				union(g.x, g.y);
				sum += g.c;
			}
		}
		
		System.out.println(sum);
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = find(parents[a]);
	}

	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot < bRoot) parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
	}
	
}
