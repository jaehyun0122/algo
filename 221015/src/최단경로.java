import java.util.*;
import java.io.*;

public class 최단경로 {

	static class Node{
		int v,w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<Node>[] list = new ArrayList[E+1];
		
		int start = Integer.parseInt(br.readLine());
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,c));
		}
		check = new boolean[V+1];
		dp = new int[V+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[start] = 0;
		sol(list, start);
		
		
		for(int a : dp) {
			System.out.println(a);
		}
		
	}
	
	static boolean[] check;
	static int[] dp;
	static void sol(ArrayList<Node>[] list, int start) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(start, 0));
		
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(check[cur.v]) continue;
			check[cur.v] = true;
			
			for(Node node : list[cur.v]) {
				if(dp[node.v] > dp[cur.v]+node.w) {
					dp[node.v] = dp[cur.v]+node.w;
					q.add(new Node(node.v, dp[node.v]));
				}
			}
		}
		
	}

}
