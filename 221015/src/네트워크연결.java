import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 네트워크연결 {

	static class Node implements Comparable<Node>{
		int a,b,c;
		
		public Node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.c - n.c;
		}
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Node> list = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.add(new Node(a,b,c));
		}
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		Collections.sort(list);
		int result = 0;
		
		for(Node node : list) {
			if(find(node.a) != find(node.b) ) {
				result += node.c;
				union(node.a, node.b);
			}
		}
		
		System.out.println(result);
		
	}
	
	static int[] parents;
	static int find(int num) {
		if(num == parents[num]) return num;
		else return parents[num] = find(parents[num]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot > bRoot) parents[aRoot] = bRoot;
		else parents[bRoot] = aRoot;
	}
}
