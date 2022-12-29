import java.util.*;
import java.io.*;

public class 네트워크연결1922 {
	
	static class Network implements Comparable<Network>{
		int a,b,c;
		
		public Network(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Network o) {
			return this.c - o.c;
		}	
	}
	static ArrayList<Network> list = new ArrayList<>();
	static int[] parents;
	
	public static void main (String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		parents = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Network(a,b,c));
		}
		Collections.sort(list);
		int ans = 0;
		
		for(int i=0; i<list.size(); i++) {
			Network net = list.get(i);
			
			if(find(net.a) != find(net.b)) {
				ans += net.c;
				union(net.a, net.b);
			}
		}
		
		System.out.println(ans);
		
	}
	
	private static int find(int num) {
		if(parents[num] == num) return num;
		else return parents[num] = find(parents[num]);
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot < bRoot) parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
	}
	
	
}
