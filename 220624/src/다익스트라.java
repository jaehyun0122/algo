import java.util.*;
import java.io.*;

public class 다익스트라 {

	static class Node implements Comparable<Node>{
		int end, w;
		
		public Node(int end, int w) {
			this.end = end;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		ArrayList<Node>[] list = new ArrayList[v+1];
		
		for(int i=1; i<=v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,c));
		}
		dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		check = new boolean[v+1];
		
		dijkstra(list, start);
		
		for(int i = 1; i<dist.length; i++) {
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}

	static int[] dist;
	static boolean[] check;
	static void dijkstra(ArrayList<Node>[] list, int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(check[cur.end]) continue;
			check[cur.end] = true;
			
			for(Node node : list[cur.end]) {
				if(dist[node.end] > dist[cur.end]+node.w) {
					dist[node.end] = dist[cur.end]+node.w;
					q.add(new Node(node.end, dist[node.end]));
				}
			}
		}
		
	}
}
